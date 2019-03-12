window.addEventListener('load', function() {
  var idToken;
  var accessToken;
  var expiresAt;

  var webAuth = new auth0.WebAuth({
    domain: 'czella.eu.auth0.com',
    clientID: 'Yb7DzwMSe3D9AXnSCxtBxs8hokh2Nx0J',
    responseType: 'token id_token',
    audience: 'https://todoapp/api',
    scope: 'openid',
    redirectUri: 'http://localhost:8080/'
  });

  var loginBtn = document.getElementById('btn-login');


  loginBtn.addEventListener('click', function(e) {
    e.preventDefault();
    webAuth.authorize();
  });

});
