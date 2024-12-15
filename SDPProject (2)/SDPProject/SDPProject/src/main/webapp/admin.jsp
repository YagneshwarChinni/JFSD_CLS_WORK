<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login & Signup</title>
  <style>
    /* General Styles */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    body {
      font-family: 'Arial', sans-serif;
      background-color: #f4f7fc;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      color: #333;
    }

    .container {
      display: flex;
      justify-content: center;
      align-items: center;
      padding: 20px;
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
      max-width: 400px;
      width: 100%;
    }

    .form-container {
      width: 100%;
    }

    h2.title {
      text-align: center;
      margin-bottom: 20px;
      color: #4A90E2;
    }

    .tabs {
      display: flex;
      justify-content: space-around;
      margin-bottom: 20px;
    }

    .tab-btn {
      width: 50%;
      padding: 10px;
      text-align: center;
      background-color: #f2f2f2;
      border: none;
      cursor: pointer;
      font-weight: bold;
      transition: background-color 0.3s;
    }

    .tab-btn.active {
      background-color: #4A90E2;
      color: white;
    }

    .form {
      display: none;
    }

    input, select {
      width: 100%;
      padding: 12px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    select {
      cursor: pointer;
    }

    button.submit-btn {
      width: 100%;
      padding: 12px;
      background-color: #4A90E2;
      border: none;
      color: white;
      font-size: 16px;
      border-radius: 4px;
      cursor: pointer;
      transition: background-color 0.3s;
    }

    button.submit-btn:hover {
      background-color: #357ABD;
    }

    button:focus, input:focus, select:focus {
      outline: none;
      border-color: #4A90E2;
    }

    /* Responsive Design */
    @media screen and (max-width: 600px) {
      .container {
        padding: 10px;
      }

      .form-container {
        width: 100%;
      }
    }
  </style>
</head>
<body>
  <div class="container">
    <div class="form-container">
      <h2 class="title">Welcome to the System</h2>
      
      <div class="tabs">
        <button class="tab-btn" id="login-tab-btn">Login</button>
        <button class="tab-btn" id="signup-tab-btn">Signup</button>
      </div>

      <!-- Login Form -->
      <div class="form" id="login-form">
        <h3>Login</h3>
        <form action="#" method="POST">
          <input type="text" id="username-login" name="username" placeholder="Username" required>
          <input type="password" id="password-login" name="password" placeholder="Password" required>
          <select id="role-login" name="role" required>
            <option value="admin">Admin</option>
            <option value="patient">Patient</option>
            <option value="doctor">Doctor</option>
          </select>
          <button type="submit" class="submit-btn">Login</button>
        </form>
      </div>

      <!-- Signup Form -->
      <div class="form" id="signup-form">
        <h3>Signup</h3>
        <form action="#" method="POST">
          <input type="text" id="username-signup" name="username" placeholder="Username" required>
          <input type="password" id="password-signup" name="password" placeholder="Password" required>
          <select id="role-signup" name="role" required>
            <option value="admin">Admin</option>
            <option value="patient">Patient</option>
            <option value="doctor">Doctor</option>
          </select>
          <button type="submit" class="submit-btn">Signup</button>
        </form>
      </div>
    </div>
  </div>

  <script>
    // Switching between Login and Signup Forms
    const loginTabBtn = document.getElementById('login-tab-btn');
    const signupTabBtn = document.getElementById('signup-tab-btn');
    const loginForm = document.getElementById('login-form');
    const signupForm = document.getElementById('signup-form');

    loginTabBtn.addEventListener('click', () => {
      loginForm.style.display = 'block';
      signupForm.style.display = 'none';
      loginTabBtn.classList.add('active');
      signupTabBtn.classList.remove('active');
    });

    signupTabBtn.addEventListener('click', () => {
      loginForm.style.display = 'none';
      signupForm.style.display = 'block';
      signupTabBtn.classList.add('active');
      loginTabBtn.classList.remove('active');
    });

    // Set default tab to Login
    loginTabBtn.click();
  </script>
</body>
</html>
