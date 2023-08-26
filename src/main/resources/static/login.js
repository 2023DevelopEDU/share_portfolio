$(document).ready(function () {
  let signup = $(".links").find("li").find("#signup");
  let signin = $(".links").find("li").find("#signin");
  let reset = $(".links").find("li").find("#reset");
  let first_input = $("form").find(".first-input");
  let hidden_input = $("form").find(".input__block").find("#repeat__password");
  let signin_btn = $("form").find(".signin__btn");

  $("#login").click(function () {
    $("#modal").fadeIn();
  });

  $("#signUp").on("click", function () {
    signup.parent().parent().siblings("h1").text("Sign up");
    signup.parent().css("opacity", "1");
    signup.parent().siblings().css("opacity", ".6");
    first_input.removeClass("first-input__block").addClass("signup-input__block");
    hidden_input.css({
      opacity: "1",
      display: "block",
    });
    signin_btn.text("회원가입하기🔥");
    $("#modal").fadeIn();
  });

  $("#modal_close_btn").click(function () {
    $("#modal").fadeOut();
  });

  //----------- sign up ---------------------
  signup.on("click", function (e) {
    e.preventDefault();
    $(this).parent().parent().siblings("h1").text("Sign up");
    $(this).parent().css("opacity", "1");
    $(this).parent().siblings().css("opacity", ".6");
    first_input.removeClass("first-input__block").addClass("signup-input__block");
    hidden_input.css({
      opacity: "1",
      display: "block",
    });
    signin_btn.text("회원가입하기🔥");
  });

  //----------- sign in ---------------------
  signin.on("click", function (e) {
    e.preventDefault();
    $(this).parent().parent().siblings("h1").text("Login");
    $(this).parent().css("opacity", "1");
    $(this).parent().siblings().css("opacity", ".6");
    first_input.addClass("first-input__block").removeClass("signup-input__block");
    hidden_input.css({
      opacity: "0",
      display: "none",
    });
    signin_btn.text("Let's GO🚀");
  });

  //----------- reset ---------------------
  reset.on("click", function (e) {
    e.preventDefault();
    $(this).parent().parent().siblings("form").find(".input__block").find(".input").val("");
  });
});
