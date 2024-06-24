



    //質問の登録
    const questions = [
      { text: "地域はどこですか？<br>地方、都道府県・市区町村で答えてね～", key: "region" },
      { text: "温泉の効能は何ですか？<br>のように答えてよ～", key: "hotSpringEffect" },
      { text: "露天風呂はあったほうがいい？<br>あり、なしで答えてくね～", key: "openAirBath" },
      { text: "景観は海と山どっちがいい？", key: "scenery" },
      { text: "お部屋にお風呂はあったほうがいい？<br>あり、なしで答えてにぇ～～", key: "privateBath" }
    ];

    const answers = {};
    let currentIndex = 0;


    function askQuestion() {
      const question = questions[currentIndex];
      // 質問を角丸枠で囲む
      document.getElementById("chat-log").innerHTML += `
        <div class="chat-message">
          <div class="bot-message">Q: ${question.text}</div>
        </div>
      `;
      document.getElementById("answer-input").focus();
    }


    document.getElementById("answer-btn").addEventListener("click", () => {
      const answer = document.getElementById("answer-input").value;
      answers[questions[currentIndex].key] = matchResult;
      console.log(`Answer: ${answer}`);
		console.log(currentIndex);
		currentIndex++;

		//正規表現
		if(currentIndex == 1){
      	const addressPattern = /((.+?[県道府都])|(.+?[市区町村]))/g;
		var matchResult = answer.match(addressPattern);
		console.log('場所:' + matchResult);
		}
		else if(currentIndex == 2){
      	const effectPattern = /(リウマチ|筋肉|冷え性|神経|腰|打撲|十肩|捻挫|胃|腸|高血圧|糖尿|コレステロール|喘息|肺気腫|痔|自律神経|ストレス|疲労)/g;
		var matchResult = answer.match(effectPattern);
		console.log(matchResult);
		}
		else if(currentIndex == 3){
      	const openAirPattern = /(あり|なし|いらない|ほしい)/g;
		var matchResult = answer.match(openAirPattern);
			if(matchResult == ('あり' | 'ほしい' )){
			matchResult = 'O';
			}else {
			matchResult = 'X';
			}
		console.log(matchResult);
		}
		else if(currentIndex == 4){
      	const scenePattern = /(海|山|)/g;
		var matchResult = answer.match(scenePattern);
		console.log(matchResult);
		}
		else if(currentIndex == 5){
      	const privatePattern = /(あり|なし|いらない|ほしい)/g;
		var matchResult = answer.match(privatePattern);
		console.log(matchResult);
			if(matchResult == 'あり' | 'ほしい' ){
			matchResult = 'O';
			}else {
			matchResult ='X';
			}
		}
      // 回答を吹き出しで囲む

      document.getElementById("chat-log").innerHTML += `
        <div class="chat-message">
          <div class="user-message">A: ${answer}</div>
        </div>
      `;
      document.getElementById("answer-input").value = "";

      if (currentIndex < questions.length) {
        askQuestion();
      } else {
        document.getElementById("chat-log").innerHTML +=
        `<div class="chat-message">
          <div class="bot-message">以上で質問は終わりです。おすすめを検索するのでお待ち下さい。</div>
        </div>`;
        console.log("All answers:", answers);


        // 非同期通信でサーブレットに送る
        const xhr = new XMLHttpRequest();
        xhr.open("POST", "http://localhost:8080/onsen-test/OnsenSearch", true);
        xhr.setRequestHeader("Content-Type", "application/json");
        console.log(JSON.stringify(answers));
        xhr.send(JSON.stringify(answers));

        xhr.onload = function() {
          if (xhr.status === 200) {
            const response = JSON.parse(xhr.responseText);
            const result = response.result;
            // おすすめ結果を吹き出しで囲む
            document.getElementById("chat-log").innerHTML +=
            `<div class="chat-message">
              <div class="bot-message">おすすめ結果：${result}</div>
            </div>`;
          } else {
            console.error("Error:", xhr.statusText);
          }
        };
      }
    });

    askQuestion();

    console.log("qa:" + questions[0].text);