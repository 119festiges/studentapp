function callAI(type, text, callback) {
    fetch('http://localhost:8081/api/ai/process', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            type: type,
            text: text
        })
    })
        .then(res => res.text())
        .then(data => callback(data))
        .catch(err => callback("Hiba történt"));
}
function showXP(points) {
    const popup = document.getElementById("xpPopup");
    popup.innerText = `+${points} XP`;
    popup.style.display = "block";

    setTimeout(() => {
        popup.style.display = "none";
    }, 1500);
}