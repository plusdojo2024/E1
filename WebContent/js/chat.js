//質問の登録
const questions = [
  { text: "どこに行きたい？<br>都道府県・市区町村で答えてね～", key: "region" },
  { text: "温泉の効能は何がいい？<br>筋肉痛、冷性のように答えてね～", key: "hotSpringEffect" },
  { text: "露天風呂はあったほうがいい？<br>あり、なしで答えてくね～", key: "openAirBath" },
  { text: "景観は海と山どっちがいい？", key: "scenery" },
  { text: "お部屋にお風呂はあったほうがいい？<br>あり、なしで答えてね～～", key: "privateBath" }
];

const answers = {};
let currentIndex = 0;

function askQuestion() {
  const question = questions[currentIndex];
  // 質問を角丸枠で囲む
  document.getElementById("question").innerHTML += `
    <div class="chat-message">
      <div class="bot-message">Q: ${question.text}</div>
    </div>
  `;
      console.log(question.text);

  document.getElementById("answer-input").focus();
}

document.getElementById("answer-btn").addEventListener("click", () => {
  var answer = document.getElementById("answer-input").value;

  console.log("Answer:" + answer);
  console.log(currentIndex);

  //正規表現
  if(currentIndex == 0){
    const addressPattern = /(.+?[県道府都市区町村])/g;
    var matchResult = answer.match(addressPattern);
    console.log(matchResult);
    answers[questions[currentIndex].key] = matchResult ? matchResult[0] : answer;
  }
  else if(currentIndex == 1){
    const effectPattern = /(リウマチ|筋肉|冷性|冷え性|神経|腰|打撲|肩|十肩|捻挫|胃|腸|高血圧|糖尿|コレステロール|喘息|肺気腫|痔|自律神経|ストレス|疲労)/g;
    var matchResult = answer.match(effectPattern);
    console.log(matchResult);
    answers[questions[currentIndex].key] = matchResult ? matchResult[0] : answer;
  }
  else if(currentIndex == 2){
    const openAirPattern = /(あり|なし|いらない|ほしい)/g;
    var matchResult = answer.match(openAirPattern);
    console.log(matchResult);
    if(matchResult && (matchResult[0] === 'あり' || matchResult[0] === 'ほしい')){
      matchResult = 'O';
    } else {
      matchResult = 'X';
    }
    answers[questions[currentIndex].key] = matchResult;
  }
  else if(currentIndex == 3){
    const scenePattern = /(海|山)/g;
    var matchResult = answer.match(scenePattern);
    console.log(matchResult);
    answers[questions[currentIndex].key] = matchResult ? matchResult[0] : answer;
  }
  else if(currentIndex == 4){
    const privatePattern = /(あり|なし|いらない|ほしい)/g;
    var matchResult = answer.match(privatePattern);
    console.log(matchResult);
    if(matchResult && (matchResult[0] === 'あり' || matchResult[0] === 'ほしい')){
      matchResult = 'O';
    } else {
      matchResult = 'X';
    }
    answers[questions[currentIndex].key] = matchResult;
  }


  // 回答を吹き出しで囲む
  const question = questions[currentIndex];
    document.getElementById("question-log").innerHTML += `
    <div class="chat-message">
      <div class="speech-bubble-question">${question.text}</div>
    </div>
    <div class="chat-message">
      <div class="speech-bubble-answer">${answer}</div>
    </div>
  `;
  document.getElementById("answer-input").value = "";
  document.getElementById("question").innerHTML = '';
currentIndex++;
  if (currentIndex < questions.length ) {
    askQuestion();
  } else {
    document.getElementById("chat-log").innerHTML +=
    `<div class="chat-message">
      <div class="bot-message">以上で質問は終わりです。おすすめを検索するのでお待ち下さい。</div>
    </div>`;
    console.log("All answers:", answers);

    // 非同期通信でサーブレットに送る
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/E1/ChatSearchServlet", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    console.log(JSON.stringify(answers));
    xhr.send(JSON.stringify(answers));

  xhr.onload = function() {
          if (xhr.status === 200) {
            const response = JSON.parse(xhr.responseText); 
            const result = response.result; 
            console.log("return data:" + result);
            // おすすめ結果を吹き出しで囲む
            //document.getElementById("chat-log").innerHTML += 
            //`<div class="chat-message">
             // <div class="bot-message">おすすめ結果：${result}</div>
            //</div>`;/E1/src/servlet/ChatSaveServlet.java
            setTimeout(function() { 
        		location.href="/E1/ChatSaveServlet?result_chat=" +result;
    		}, 3000); // 3000ミリ秒 = 3秒
           
          } else {
            console.error("Error:", xhr.statusText);
          }
        };
  }
});

askQuestion();