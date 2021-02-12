# Project1_Preston

## Description

This project is a Tuition Reimbursement System, TRMS, for employees to submit tuition reimbursements for courses, training, seminars, certifications and any other learning they would like to recieve a reimbursement. Once the employee has attended the event/course/training they will need to submit a grade or presentation that is passing for the tuition form to be approved. After the grade is submitted, the tuition reimbursement form must be approved by that employee's supervisor, department head, and benefits coordinator before they will recieve a reimbursement amount. Each employee is allotted $1000 in tuition reimbursements, once a reimbursement has been fully approved the amount that employee received will be deducted from their total, showing the employee how much money they have left for future tuition reimbursements.

## Technologies Used
* Java
* Oracle SQL
* JDBC
* Apache Tomcat
* Servlets
* Javascript
* HTML/CSS
* Bootstrap

## Features
* All employees can login and logout
* Employees can view their submitted tuition forms
* Employees can submit a passing or failing grade/presentation
* Supervisors/Department Heads can view and approve/deny their subordinates tuition forms
* The Benefit Coordinator can view and approve/deny all employees tuition forms
* Tuition Status is updated after the tuition form has been fully approved

To-Do Features
* Clean up the UI design
* Add a bit more functionality with the tables that the employees see

## Getting Started
git clone git@github.com:Prest261/Project1_Preston.git
download the Apache Tomcat server to host the application.
Set up a database through whichever is your hosting go-to, I used AWS with Oracle SQL
make sure all the dependencies are in the pom.xml

## Usage
Navigate to your localhost:8080/Project1_Preston and you should arrive at the login page
Login as a user that exists in your database and you can create tuition forms, view your tuition forms, or update grades
If your user is a Department Head or Benefits Coordinator then they have the ability to approve/deny other tuition forms

## Contributors
Sydney Preston

## License
MIT License

Copyright (c) [2019] [Sydney Preston]

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
