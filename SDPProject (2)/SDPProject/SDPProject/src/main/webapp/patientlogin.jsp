<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patient Login & SignUp - Unity Hospital</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <%@ include file="mainnavbar.jsp" %>

    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f6f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column;
        }

        header {
            background-color: #2c3e50;
            color: #fff;
            text-align: center;
            padding: 15px;
            width: 100%;
            font-size: 24px;
        }

        .form-container {
            text-align: center;
            margin-top: 30px;
        }

        .form-container button {
            background-color: #72c02c;
            border: none;
            color: white;
            padding: 15px 30px;
            font-size: 18px;
            border-radius: 6px;
            cursor: pointer;
            width: 200px;
            margin: 10px;
            transition: background-color 0.3s ease;
        }

        .form-container button:hover {
            background-color: #5a9f26;
        }

        /* Modal Styles */
        .modal {
            display: none; 
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.5);
            padding-top: 50px;
        }

        .modal-content {
            background-color: #fff;
            margin: 5% auto;
            padding: 20px;
            border-radius: 8px;
            width: 40%;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            animation: slideIn 0.3s ease-out;
        }

        @keyframes slideIn {
            from {
                opacity: 0;
                transform: translateY(-50px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .close {
            color: #aaa;
            font-size: 30px;
            font-weight: bold;
            position: absolute;
            top: 10px;
            right: 20px;
        }

        .close:hover,
        .close:focus {
            color: black;
            cursor: pointer;
        }

        h3 {
            font-size: 26px;
            color: #2c3e50;
            text-align: center;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            margin-top: 20px;
        }

        td {
            padding: 10px;
            text-align: left;
            font-size: 16px;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"],
        input[type="date"],
        input[type="number"] {
            width: 100%;
            padding: 12px;
            margin: 8px 0;
            border: 1px solid #ddd;
            border-radius: 6px;
            background-color: #f9f9f9;
            font-size: 16px;
        }

        input[type="submit"],
        input[type="reset"] {
            background-color: #72c02c;
            border: none;
            color: white;
            padding: 12px 20px;
            font-size: 16px;
            border-radius: 6px;
            cursor: pointer;
            width: 48%;
            margin: 5px 1%;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #5a9f26;
        }

        .button-container {
            text-align: center;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .modal-content {
                width: 80%;
            }

            .form-container button {
                width: 150px;
                padding: 12px;
                font-size: 16px;
            }
        }

        @media (max-width: 480px) {
            .modal-content {
                width: 90%;
            }

            .form-container button {
                width: 100%;
                padding: 12px;
                font-size: 14px;
            }
        }
    </style>
</head>
<body>

    <header>
        Unity Hospital - Patient Portal
    </header>

    <!-- Form Container for Buttons -->
    <div class="form-container">
        <button id="loginBtn">Patient Login</button>
        <button id="signupBtn">Patient SignUp</button>
    </div>

    <!-- Patient Login Modal -->
    <div id="loginModal" class="modal">
        <div class="modal-content">
            <span class="close" id="closeLogin">&times;</span>
            <h3>Patient Login</h3>
            <form method="post" action="checkpatientlogin">
                <table>
                    <tr>
                        <td><label for="puname">Enter Email</label></td>
                        <td><input type="text" id="puname" name="puname" required /></td>
                    </tr>
                    <tr>
                        <td><label for="ppwd">Enter Password</label></td>
                        <td><input type="password" id="ppwd" name="ppwd" required /></td>
                    </tr>
                    <tr>
                        <td colspan="2" class="button-container">
                            <input type="submit" value="Login" />
                            <input type="reset" value="Clear" />
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

    <!-- Patient SignUp Modal -->
    <div id="signupModal" class="modal">
        <div class="modal-content">
            <span class="close" id="closeSignup">&times;</span>
            <h3>Patient SignUp</h3>
            <form method="post" action="registerpatient">
                <table>
                    <tr>
                        <td><label for="pname">Enter Name</label></td>
                        <td><input type="text" id="pname" name="pname" required /></td>
                    </tr>
                    <tr>
                        <td><label for="pemail">Enter Email ID</label></td>
                        <td><input type="email" id="pemail" name="pemail" required /></td>
                    </tr>
                    <tr>
                        <td><label for="pcontact">Enter Contact</label></td>
                        <td><input type="number" id="pcontact" name="pcontact" required /></td>
                    </tr>
                    <tr>
                        <td><label for="ppassword">Enter Password</label></td>
                        <td><input type="password" id="ppassword" name="ppassword" required /></td>
                    </tr>
                    <tr>
                        <td><label for="pdob">Enter Date of Birth</label></td>
                        <td><input type="date" id="pdob" name="pdob" required /></td>
                    </tr>
                    <tr>
                        <td colspan="2" class="button-container">
                            <input type="submit" value="SignUp" />
                            <input type="reset" value="Clear" />
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

    <script>
        // Modal functionality
        var loginModal = document.getElementById("loginModal");
        var signupModal = document.getElementById("signupModal");
        var loginBtn = document.getElementById("loginBtn");
        var signupBtn = document.getElementById("signupBtn");
        var closeLogin = document.getElementById("closeLogin");
        var closeSignup = document.getElementById("closeSignup");

        loginBtn.onclick = function() {
            loginModal.style.display = "block";
        }

        signupBtn.onclick = function() {
            signupModal.style.display = "block";
        }

        closeLogin.onclick = function() {
            loginModal.style.display = "none";
        }

        closeSignup.onclick = function() {
            signupModal.style.display = "none";
        }

        window.onclick = function(event) {
            if (event.target == loginModal) {
                loginModal.style.display = "none";
            }
            if (event.target == signupModal) {
                signupModal.style.display = "none";
            }
        }
    </script>

</body>
</html>
