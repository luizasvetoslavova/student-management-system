Build a Student Management System.

1. **Adding new students** (name, ID, grade):

The system must allow adding new students by collecting their name, a positive integer ID, and a valid grade (integer between 1 and 12 inclusive).

The ID must be unique — duplicate IDs must be rejected and the user must be prompted to enter a new one until a valid, unique ID is provided.

The input for name must not be empty, and the system must repeatedly request input if invalid data is entered.

2. **Removing students by ID**:

The system must allow removing an existing student by their ID.

Before removal, the entered ID must be validated:

It must be a positive integer.

It must already exist in the list of students.

If an invalid or non-existing ID is entered, the system must prompt the user again until a valid, existing ID is provided.

Upon successful removal, the system should confirm with a message.

3. **Displaying all students sorted by name**:

The system must display all current students, sorted alphabetically by their names.

If no students are present, the system must inform the user that no students are found.

Sorting must prioritize readability: identical names must remain in insertion order or according to ID if necessary.

The sort implementation should favor clarity and maintainability over manual algorithm writing.

4. **Searching for a student by ID**:

The system must allow searching for a specific student based on their ID.

The input must be validated as a positive integer.

If the student with the given ID exists, the system should display their full details (name, ID, grade).

If no student matches the entered ID, an appropriate message should notify the user.

5. **Use ArrayList for storing students**:

The collection of students must be managed through a java.util.ArrayList.

The system should use dynamic storage, allowing any number of students without predefined size limits.

All operations (adding, removing, searching, displaying) must act on this ArrayList directly.

6. **Follow object-oriented programming principles**:

The program structure must respect OOP best practices:

Separate classes for different concerns.

Use interfaces to define clear contracts for functionalities (e.g., adding, removing, input management, validation).

Implement the Singleton pattern where centralized management is appropriate (e.g., one instance of StudentManager and InputManager).

Data fields (name, id, grade) must be private and accessed via public getters.

To display a student, a properly overridden toString() method should be used.

7. **Handle invalid input** (e.g., non-existing IDs for removal/search):

All user input must be validated before proceeding:

Non-numeric input must be rejected for ID and grade fields.

IDs must be positive and, depending on context, must either already exist (for removal/search) or not exist (for adding).

Grades must be positive integers within a valid school-grade range (1–12).

If invalid input is detected, the system must not crash. Instead, it must repeatedly prompt the user for correction.

All validation processes must be centralized inside appropriate methods (e.g., in a Validation-implementing class), not scattered throughout the code.

