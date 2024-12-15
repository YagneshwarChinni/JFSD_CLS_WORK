<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login - Unity Hospital</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <%@include file="mainnavbar.jsp" %>

    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #2c3e50;
            padding: 15px;
            color: #fff;
            text-align: center;
        }

        h3 {
            color: #2c3e50;
            font-size: 24px;
            text-decoration: underline;
        }

        .form-container {
            background-color: #fff;
            width: 40%;
            margin: 50px auto;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .form-container table {
            width: 100%;
        }

        .form-container td {
            padding: 10px;
            text-align: left;
        }

        .form-container label {
            font-size: 16px;
            color: #555;
        }

        .form-container input[type="text"],
        .form-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            background-color: #f9f9f9;
        }

        .form-container input[type="submit"],
        .form-container input[type="reset"] {
            background-color: #72c02c;
            border: none;
            color: white;
            padding: 12px 20px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            width: 48%;
            margin: 5px 1%;
            transition: background-color 0.3s ease;
        }

        .form-container input[type="submit"]:hover,
        .form-container input[type="reset"]:hover {
            background-color: #5a9f26;
        }

        .form-container .button-container {
            text-align: center;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .form-container {
                width: 70%;
            }
        }

        @media (max-width: 480px) {
            .form-container {
                width: 90%;
            }
        }
    </style>
</head>
<body>

    <header>
        <h1>Unity Hospital</h1>
        <p>Admin Portal</p>
    </header>

    <div class="form-container">
        <h3>Admin Login</h3>
        <form method="post" action="checkadminlogin">
            <table>
                <tr>
                    <td><label for="auname">Enter Username</label></td>
                    <td><input type="text" id="auname" name="auname" required/></td>
                </tr>
                <tr>
                    <td><label for="apwd">Enter Password</label></td>
                    <td><input type="password" id="apwd" name="apwd" required/></td>
                </tr>
                <tr>
                    <td colspan="2" class="button-container">
                        <input type="submit" value="Login"/>
                        <input type="reset" value="Clear"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>
