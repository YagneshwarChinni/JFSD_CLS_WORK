<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Contact - Unity Hospital</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <%@include file="mainnavbar.jsp" %>

    <!-- Web Fonts -->
    <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600&amp;subset=cyrillic,latin">

    <!-- CSS Global Compulsory -->
    <link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <!-- CSS Header and Footer -->
    <link rel="stylesheet" href="assets/css/header.css">
    <link rel="stylesheet" href="assets/css/footer.css">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="assets/plugins/line-icons-pro/styles.css">
    <link rel="stylesheet" href="assets/plugins/line-icons/line-icons.css">
    <link rel="stylesheet" href="assets/plugins/font-awesome/css/font-awesome.min.css">

    <!-- CSS Customization -->
    <link rel="stylesheet" href="assets/css/custom.css">

    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f6f9;
            margin: 0;
            padding: 0;
        }

        .contact-container {
            margin-top: 50px;
            padding: 50px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .contact-container h2 {
            text-align: center;
            color: #2c3e50;
            font-size: 36px;
            margin-bottom: 30px;
        }

        .contact-container p {
            text-align: center;
            font-size: 16px;
            color: #7f8c8d;
            margin-bottom: 40px;
        }

        .contact-form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .contact-form input,
        .contact-form textarea {
            width: 100%;
            padding: 12px;
            margin: 8px 0;
            border: 1px solid #ddd;
            border-radius: 6px;
            background-color: #f9f9f9;
            font-size: 16px;
        }

        .contact-form button {
            background-color: #72c02c;
            color: white;
            padding: 15px 30px;
            font-size: 18px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .contact-form button:hover {
            background-color: #5a9f26;
        }

        .contact-info {
            margin-top: 50px;
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
        }

        .contact-info div {
            width: 300px;
            margin: 20px;
            text-align: center;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .contact-info i {
            font-size: 40px;
            color: #72c02c;
        }

        .contact-info h4 {
            margin-top: 15px;
            color: #2c3e50;
            font-size: 22px;
        }

        .contact-info p {
            color: #7f8c8d;
        }
    </style>

</head>

<body>

    <!-- Contact Form Section -->
    <div class="container contact-container">
        <h2>Contact Us</h2>
        <p>If you have any questions or inquiries, please don't hesitate to contact us. Our team is here to assist you.</p>

        <form class="contact-form" method="post" action="submitcontact">
            <input type="text" name="name" placeholder="Your Name" required />
            <input type="email" name="email" placeholder="Your Email" required />
            <input type="text" name="subject" placeholder="Subject" required />
            <textarea name="message" placeholder="Your Message" rows="5" required></textarea>
            <button type="submit">Send Message</button>
        </form>
    </div>

    <!-- Contact Information Section -->
    <div class="container contact-info">
        <div>
            <i class="fa fa-phone"></i>
            <h4>Call Us</h4>
            <p>+91 123 456 7890</p>
        </div>
        <div>
            <i class="fa fa-envelope"></i>
            <h4>Email Us</h4>
            <p>info@unityhospital.com</p>
        </div>
        <div>
            <i class="fa fa-map-marker"></i>
            <h4>Visit Us</h4>
            <p>Unity Hospital, Ahmedabad, Gujarat, India</p>
        </div>
    </div>

</body>
</html>
