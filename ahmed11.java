const buttons = document.querySelectorAll('.custom-button');

buttons.forEach(button => {
    button.addEventListener('click', () => {
        button.style.background = 'linear-gradient(90deg, #ff0000, #ff8800)';
        button.style.boxShadow = '0 0 20px rgba(255, 0, 0, 0.6)';
    });
});