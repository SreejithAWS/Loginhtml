<?php
  // check if form has been submitted
  if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // get form data
    $username = $_POST['username'];
    $password = $_POST['password'];
    
    // validate username and password
    if ($username == 'myusername' && $password == 'mypassword') {
      // if valid, redirect to the home page
      header('Location: home.html');
      exit();
    } else {
      // if invalid, display an error message
      $error = 'Invalid username or password.';
    }
  }
?>

<!DOCTYPE html>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <h2>Login</h2>
    <?php if (isset($error)) { ?>
      <p><?php echo $error; ?></p>
    <?php } ?>
    <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
      <label for="username">Username:</label>
      <input type="text" id="username" name="username"><br><br>
      <label for="password">Password:</label>
      <input type="password" id="password" name="password"><br><br>
      <input type="submit" value="Login">
    </form>
  </body>
</html>
