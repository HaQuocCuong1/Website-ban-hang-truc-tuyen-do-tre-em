const modal_addproduct = document.getElementById('modal-add-product');
const btnback = document.getElementById('btnback');
const addproduct = document.getElementById('button-add-product');
const menu_color = document.getElementById('menu-item--link');
const menuitem_link = document.getElementById('menu-item--link');

addproduct.addEventListener('click', ()=>{
    modal_addproduct.classList.remove('modal-addproduct--disable');
});
btnback.addEventListener('click', ()=>{
    modal_addproduct.classList.add('modal-addproduct--disable');
});
menuitem_link.addEventListener('click', ()=>{
    menu_color.classList.remove('menu-item--color');
    menu_color.classList.add('menu-item--color');
});
