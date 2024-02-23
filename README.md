# Log File Analyzer

This Java program analyzes a log file and extracts information about errors and user activities.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your system.
- A text editor or an Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse.

### Installation

1. Clone or download the repository to your local machine.
2. Open the project in your preferred IDE or text editor.

### Usage

1. Ensure that the log file (logfile.txt) is present in the specified file path.
2. Compile and run the Main.java file.
3. The program will read the log file, analyze it, and print the count of errors and user activities.

## Functionality

- The program reads each line of the log file and extracts timestamp and log message.
- It counts occurrences of errors and logs user activities.
- Error messages are identified if the timestamp ends with "ERROR".
- User activities are logged if the timestamp ends with "INFO" and the log message contains "User".

## File Structure

- Main.java: Main class containing the main() method to execute the program.
- logfile.txt: Sample log file for testing purposes.
