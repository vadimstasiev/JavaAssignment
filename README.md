##### Note: If you want to get started setting up the project head to the [setting up readme](./Learning_Resources/2-Setting_Up/README.md).
# EVA - Simplified Brief


|   Deadline	|   Before 10am on: 29/05/2020	|
|--- 	|--- 	|
|   Unit title & code	|   CIS016-1 Principles of Programming / CIS096-1 Principles of Programming and Data Structures	|
|   Weighting of Assessment	|   70%	|
|   Assessment type 	|   Code and Report // Presentation    |
    “Submit a word-processed report detailing the work that you have done. // Submit an individual video presentation about your work.”
## Tasks

1. Develop an appropriate part of the Student Event Management System (see Task Description). 

2. Code and test the critical features your application using programming facilities of Java language such as, e.g., GUIs, I/O file operations, Networking classes, JDBC etc. In case your task involves a database, please carefully design your database using your database design and SQL skills.

## Deliverables 
1. Project Report (max 9000 words or 2 pages), 20% of grade Illustrate and justify your choices in analysis and implementation. ***Provide evidence that you actually tested your code.*** Any code may go into the appendix, except core classes that you may explain in the main text. 
    - This is a formal report and attention should be given to the format of this work. You should include a title page, table of contents, heading and sub-headings (introduction, main part, summary, appendices), and captions for figures.
    - You are strongly advised to use the report template provided. 

2. Each student, has to upload a short video of up to 5 minutes maximum where they vocally explain their contribution to the group project. Such an explanation should show the parts they implemented and explain some chosen example code they developed. 

3. A .zip file containing your running the complete program code, 50% of grade.
    - Instructions how to run the code should go into the project report above.
## Possible Discussion Topics for the Report
    - Reflect upon your strength and weaknesses in relation to a programming project you have undertaken and use these to improve your program code 3
    - Outline a test routine to check the logical correctness of a program you have written and provide the results of your testing demonstrating a working piece of code
## The Actual Task
### Extra-curricular eVent mAnagement (EVA)
Your task is to create a Java desktop application to create and manage student-led events at the university.
- Event Properties:
    - Online or Physical
        - Online => URL
        - Physical => Location
    - Title and description
    - Time and date
    - Place limitations (e.g. up to 30 participants)
- Student:
Student:
- Properties:
    - name
    - student ID
    - password
    - isOrganizer = True // False
        > “An administrator can provide a student with event organisation rights (essentially making a student an event organizer) or revoke these rights. The administrator can view all events and bookings. They can also cancel events or bookings.” 
- to Register:
    - name
    - student ID
    - password
- Login with (student ID, password):
    - Views:
        - (SHOW TO ALL STUDENTS)
            - Events View
                - Book events
            - Booked Events List View
                - Cancel Booking
        - (SHOW ONLY to ORGANIZER = YES)
            - Post Events View
            - View Listed Events View
                - Cancel Events
                    - Note: “In case of event cancellation all bookings associated with an event have to automatically be canceled, too.”
                - Modify Events
