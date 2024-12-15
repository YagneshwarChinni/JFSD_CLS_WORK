<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Doctor Registration</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

    <header>
        Doctor Registration - Unity Hospital
    </header>

    <div class="form-container">
        <h3>Doctor Registration Form</h3>
        <form method="post" action="/registerdoctor">
            <table>
                <tr>
                    <td><label for="dname">Name:</label></td>
                    <td><input type="text" id="dname" name="dname" required /></td>
                </tr>
                <tr>
                    <td><label for="demail">Email ID:</label></td>
                    <td><input type="email" id="demail" name="demail" required /></td>
                </tr>
                <tr>
                    <td><label for="dcontact">Contact:</label></td>
                    <td><input type="number" id="dcontact" name="dcontact" required /></td>
                </tr>
                <tr>
                    <td><label for="dpassword">Password:</label></td>
                    <td><input type="password" id="dpassword" name="dpassword" required /></td>
                </tr>
                <tr>
                    <td><label for="dspecialty">Specialty:</label></td>
                    <td><input type="text" id="dspecialty" name="dspecialty" required /></td>
                </tr>
                <tr>
                    <td><label for="dlocation">Location:</label></td>
                    <td><input type="text" id="dlocation" name="dlocation" required /></td>
                </tr>
                <tr>
                    <td><label for="ddob">Date of Birth:</label></td>
                    <td><input type="date" id="ddob" name="ddob" required /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Register" />
                    </td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>
