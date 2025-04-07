
btnFilme = document.querySelector("#botao-portfolio-filmes");
btnFilme.addEventListener ("click", function() {
    window.open("https://caiosenaf15.github.io/FIlmes/", "_blank");
})


btnCep = document.querySelector("#botao-portfolio-cep");
btnCep.addEventListener ("click", function() {
    window.open("https://caiosenaf15.github.io/Cep/", "_blank");
})

btnCardapio = document.querySelector("#botao-portfolio-cardapio");
btnCardapio.addEventListener ("click", function() {
    window.open("https://caiosenaf15.github.io/Cardapio/", "_blank");
})

btnLivros = document.querySelector("#botao-portfolio-livros");
btnLivros.addEventListener ("click", function() {
    window.open("https://caiosenaf15.github.io/Livraria/", "_blank");
})

btnLogin = document.querySelector("#botao-portfolio-login");
btnLogin.addEventListener ("click", function() {
    window.open("https://caiosenaf15.github.io/Projetos/Login/index.html", "_blank");
})

btnAndroid = document.querySelector("#botao-portfolio-android");
btnAndroid.addEventListener ("click", function() {
    window.open("https://caiosenaf15.github.io/HTML-CSS/CursoEmVideo/desafios/M%C3%B3dulo%202/d010/d010.html", "_blank");
})

btnCordel = document.querySelector("#botao-portfolio-cordel");
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

function mostrarEmail() {
    const popup = document.getElementById('popup-email');
    popup.style.display = 'block';

    // Fecha o pop-up depois de 5 segundos caso não clique nele
    setTimeout(() => {
        popup.style.display = 'none';
    }, 5000);
}

function copiarEmail() {
    const email = 'caiofreitas15@yahoo.com.br';
    
    // Copiar para área de transferência
    navigator.clipboard.writeText(email).then(() => {
        mostrarAvisoCopiado();
    }).catch(err => {
        alert('Erro ao copiar email: ' + err);
    });
}

function mostrarAvisoCopiado() {
    const msg = document.getElementById('copiado-msg');
    msg.style.display = 'block';

    setTimeout(() => {
        msg.style.display = 'none';
        document.getElementById('popup-email').style.display = 'none'; // Fecha pop-up depois de copiar
    }, 2000);
}


