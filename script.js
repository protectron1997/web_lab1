let sendButton = document.getElementById('send-button');
let sendStatusBlock = document.getElementById('send-status');
let tableStatusTable = document.getElementById('table-status-table');
let dotStatus = document.getElementsByClassName('dot-status');





sendButton.onclick = function () {


    let xValue = document.getElementById("x-input").value;
    let rValue = document.getElementById("r-input").value;
    let yValue;
    let yInput = document.querySelector('input[name="y-value"]:checked');
    if (yInput) {
        yValue = yInput.value;
    }


    const validateResult = validateInputs(xValue, yValue, rValue);
    if (!validateResult.isValid) {
        sendStatusBlock.innerText = validateResult.errorMessage;
        return;
    }
    else {
        sendStatusBlock.innerText = '';
    }

    async function doRequest() {
        try {
            const coords = new URLSearchParams({
                x: xValue,
                y: yValue,
                r: rValue,
            });
            const url = `/fastcgi?${coords.toString()}`;
            let response = await fetch(url);

            if (response.ok) {
                let textStatus = await response.json();
                console.log(textStatus);
                console.log(textStatus.result);
                console.log(textStatus.time_exec);
                console.log(textStatus.date);


                if (textStatus.result == "true") {
                    console.log("есть пробитие!");
                    dotStatus[0].innerHTML = '<img src="./gifs/neo.gif">';
                }
                else {
                    console.log("промах");
                    dotStatus[0].innerHTML = '<img src="./gifs/smith.webp">';
                }

                addRowToTable(xValue, yValue, rValue, textStatus);

                // const newRow = document.createElement('tr');
                // const xCell = document.createElement('td');
                // xCell.textContent = xValue;
                // newRow.appendChild(xCell);

                // const yCell = document.createElement('td');
                // yCell.textContent = yValue;
                // newRow.appendChild(yCell);

                // const rCell = document.createElement('td');
                // rCell.textContent = rValue;
                // newRow.appendChild(rCell);

                // const timeCell = document.createElement('td');
                // timeCell.textContent = textStatus.time_exec;
                // newRow.appendChild(timeCell);

                // const dateCell = document.createElement('td');
                // dateCell.textContent = textStatus.date;
                // newRow.appendChild(dateCell);

                // const resultCell = document.createElement('td');
                // resultCell.textContent = textStatus.result;
                // newRow.appendChild(resultCell);


                // tableStatusTable.appendChild(newRow);

            }
            else {
                throw new Error;
            }
        }
        catch {
            console.log("ERROR!")
            sendStatusBlock.innerText = 'что-то пошло не по плану';
        }
    }

    doRequest();
};



function validateInputs(xValue, yValue, rValue){
    let isValid = true;
    let errorMessage = '';


    if (isNaN(xValue) || xValue < -5 || xValue > 3 || xValue === '') {
        isValid = false;
        errorMessage += 'Значение X должно быть числом в диапазоне от -5 до 3.\n';

    }


    if (yValue === undefined) {
        isValid = false;
        errorMessage += 'Выберите значение Y.\n';
    }


    if (isNaN(rValue) || rValue < 2 || rValue > 5) {
        isValid = false;
        errorMessage += 'Значение R должно быть числом в диапазоне от 2 до 5.\n';
    }

    return {isValid, errorMessage};
}


function addRowToTable(xValue,yValue,rValue, textStatus){
    const newRow = document.createElement('tr');
                const xCell = document.createElement('td');
                xCell.textContent = xValue;
                newRow.appendChild(xCell);

                const yCell = document.createElement('td');
                yCell.textContent = yValue;
                newRow.appendChild(yCell);

                const rCell = document.createElement('td');
                rCell.textContent = rValue;
                newRow.appendChild(rCell);

                const timeCell = document.createElement('td');
                timeCell.textContent = textStatus.time_exec;
                newRow.appendChild(timeCell);

                const dateCell = document.createElement('td');
                dateCell.textContent = textStatus.date;
                newRow.appendChild(dateCell);

                const resultCell = document.createElement('td');
                resultCell.textContent = textStatus.result;
                newRow.appendChild(resultCell);


                tableStatusTable.appendChild(newRow);
}