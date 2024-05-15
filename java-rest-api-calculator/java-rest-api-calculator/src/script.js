function add() {
    performOperation('add');
}

function subtract() {
    performOperation('subtract');
}

function multiply() {
    performOperation('multiply');
}

function divide() {
    performOperation('divide');
}

function performOperation(operation) {
    var num1 = parseInt(document.getElementById("number1").value);
    var num2 = parseInt(document.getElementById("number2").value);

    if (isNaN(num1) || isNaN(num2)) {
        document.getElementById("result").innerText = "Please enter valid numbers";
        return;
    }

    fetch(`http://localhost:5000/${operation}?a=${num1}&b=${num2}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById("result").innerText = "Result: " + data.result;
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
