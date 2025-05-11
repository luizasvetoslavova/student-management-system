<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>

<h1>🎓 Student Management System</h1>
<p>A <strong>Java console application</strong> that dynamically manages student records, fully integrated with <strong>NeonDB (PostgreSQL)</strong>.</p>

<hr>

<h2>🚀 Main Features</h2>

<h3>➤ Add New Students</h3>
<ul>
    <li>Collects <strong>name</strong>, <strong>unique positive ID</strong>, and <strong>grade</strong> (1–12 inclusive).</li>
    <li>Validates inputs: no duplicate IDs, and grade must be in a valid school range.</li>
    <li>Prompts user repeatedly until valid input is provided.</li>
</ul>

<h3>➤ Remove Students by ID</h3>
<ul>
    <li>Validates if the student ID exists before attempting removal.</li>
    <li>Provides clear feedback if no match is found.</li>
</ul>

<h3>➤ Display All Students</h3>
<ul>
    <li>Shows all students <strong>sorted alphabetically</strong> by name.</li>
    <li>Informs if no students are available.</li>
</ul>

<h3>➤ Search for a Student</h3>
<ul>
    <li>Allows searching by <strong>ID</strong> and displays full student details.</li>
    <li>Displays an informative message if no matching record is found.</li>
</ul>

<hr>

<h2>🛠 Architecture and Design</h2>

<h3>➤ Clean Object-Oriented Structure</h3>
<ul>
    <li>Separate classes for input handling, student management, database access, and UI flow.</li>
    <li>Interfaces define modular contracts for each system responsibility.</li>
</ul>

<h3>➤ Robust Database Management</h3>
<ul>
    <li>Persistent storage using <strong>PostgreSQL</strong> and <strong>JDBC</strong>.</li>
    <li>Secure <strong>SSL-encrypted</strong> connections with NeonDB.</li>
</ul>

<h3>➤ Singleton Pattern</h3>
<ul>
    <li>Singleton implementation for centralized access in <code>StudentManager</code>, <code>InputCollector</code>, and <code>StudentDao</code>.</li>
</ul>

<h3>➤ Centralized Input Validation</h3>
<ul>
    <li>All input checks handled by reusable, centralized methods to keep the code clean and maintainable.</li>
</ul>

<hr>

<h2>📈 Highlights</h2>
<ul>
    <li>📦 <strong>Dynamic Storage</strong> — Scales with the database, no artificial limits.</li>
    <li>🔒 <strong>Robust Validation</strong> — Handles invalid inputs gracefully without crashes.</li>
    <li>🛠 <strong>Maintainable Architecture</strong> — Clear separation of concerns.</li>
    <li>🌐 <strong>Secure Database Access</strong> — Encrypted communication with NeonDB.</li>
</ul>

<hr>

<h2>📋 Quick Summary</h2>
<blockquote>
    A dynamic, professional-grade Java application for managing student data, combining <strong>robust database integration</strong>, <strong>centralized validation</strong>, and <strong>clean object-oriented design</strong> — built for reliability, scalability, and maintainability.
</blockquote>

<hr>

<h2>🧩 Class Structure Overview</h2>

<pre>
Main.java            -> Launches the program, creates ProgramRunner
ProgramRunner.java   -> Handles user interaction and menu flow
StudentManager.java  -> Core logic for adding, removing, displaying students
StudentDao.java      -> Connects to PostgreSQL database, performs CRUD operations
InputCollector.java  -> Collects and validates user input from the console
Student.java         -> Model class representing a Student
Interfaces           -> Define modular contracts for each system responsibility
</pre>

<hr>

<h2>💬 Notes</h2>
<ul>
    <li>Built for <strong>extensibility</strong> — ready for adding features like updating student details.</li>
    <li>Designed with <strong>best practices</strong> in Java, JDBC, and database management.</li>
</ul>

<hr>

<h2>🖥️ Tech Stack</h2>
<ul>
    <li><strong>Java 17+</strong></li>
    <li><strong>NeonDB (PostgreSQL)</strong> — Cloud database</li>
    <li><strong>JDBC</strong> — Java Database Connectivity</li>
    <li><strong>Gradle</strong> — Build automation</li>
</ul>

<hr>

<h2>📜 License</h2>
<p>This project is licensed for educational and professional development purposes.</p>

</body>
</html>
