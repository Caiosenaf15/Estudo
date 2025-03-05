let res = document.getElementById("idade");
const data = new Date();
let idadeAtual = data.getFullYear() - 1999 - 1;
if(data.getMonth() == 12 && data.getDay >= 15){
    idadeAtual = idadeAtual + 1;
}

btnFilme = document.querySelector("#botao-portifolio-filmes");
btnFilme.addEventListener ("click", function() {
    window.open("https://caiosenaf15.github.io/FIlmes/", "_blank");
})


btnCep = document.querySelector("#botao-portifolio-cep");
btnCep.addEventListener ("click", function() {
    window.open("https://caiosenaf15.github.io/Cep/", "_blank");
})

btnCardapio = document.querySelector("#botao-portifolio-cardapio");
btnCardapio.addEventListener ("click", function() {
    window.open("https://caiosenaf15.github.io/Cardapio/", "_blank");
})

btnLivros = document.querySelector("#botao-portifolio-livros");
btnLivros.addEventListener ("click", function() {
    window.open("https://caiosenaf15.github.io/Livraria/", "_blank");
})

btnLogin = document.querySelector("#botao-portifolio-login");
btnLogin.addEventListener ("click", function() {
    window.open("https://caiosenaf15.github.io/Projetos/Login/index.html", "_blank");
})

btnAndroid = document.querySelector("#botao-portifolio-android");
btnAndroid.addEventListener ("click", function() {
    window.open("https://caiosenaf15.github.io/HTML-CSS/CursoEmVideo/desafios/M%C3%B3dulo%202/d010/d010.html", "_blank");
})

btnCordel = document.querySelector("#botao-portifolio-cordel");
btnCordel.addEventListener ("click", function() {
    window.open("https://caiosenaf15.github.io/HTML-CSS/CursoEmVideo/desafios/M%C3%B3dulo%202/d012/d012.html", "_blank");
})

let sobreFixo = document.querySelector("#sobre-fixo");
sobreFixo.addEventListener("click", function() {
    window.scrollBy(0,100);
})


window.addEventListener('scroll', function() {
    const menu = document.querySelector('.header-fixo');
    const triggerHeight = 200; // altura em que o menu deve aparecer (pode ajustar)

    if (window.scrollY >= triggerHeight) {
        menu.style.transform = 'translateY(0)';
        menu.style.boxShadow = "5px 5px 15px rgba(0, 0, 0, 0.315)"
    } else {
        menu.style.transform = 'translateY(-100%)';
    }
});