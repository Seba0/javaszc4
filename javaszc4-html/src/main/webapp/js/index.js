let body = document.querySelector('body');
let header = document.querySelector('header');
let footer = document.querySelector('footer');

let toggleBackgroundButton = document.querySelector('.toggle-background');
let weather = document.querySelector('.weather');

const elements = [header, footer];

let switchBackground = () =
>
{
    if (body.classList.contains('background-white')) {
        body.classList.remove('background-white');
        body.classList.add('background-dark')

        elements.forEach(element = > {
            element.classList.remove('background-blue');
        element.classList.add('background-yellow');
    })
    } else {
        body.classList.remove('background-dark');
        body.classList.add('background-white')

        elements.forEach(element = > {
            element.classList.remove('background-yellow');
        element.classList.add('background-blue');
    })
    }
}
;

toggleBackgroundButton.addEventListener('click', switchBackground);