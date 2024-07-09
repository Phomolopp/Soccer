# Overview
The provided Java code implements a simple GUI application using the Swing framework. This application allows users to register new players with specific attributes and display the registered players. The attributes for each player include name, position, preferred foot, and fee. The player information is stored in a file named "data.txt".

# Components
Main Class (main)
Purpose: The entry point of the application, which initializes the Player GUI.
Player Class (Player)
Purpose: Manages the GUI and the logic for registering and displaying players.
Extends: JFrame
# GUI Components:
Panels: For organizing layout (e.g., registerPanel, namePanel, PositionPanel, preferredFootPanel, feePanel, buttonPanel, firstPanel, mainPanel, textAreaPanel).
Labels: Display text prompts (e.g., registerLnameLabel, nameLabel, positionLabel, preferredFootLabel, feeLabel).
Text Fields: Input for the player's name (nameField).
Combo Boxes: Selection for the player's position (positionComboBox) and preferred foot (preferredFootComboBox).
Spinner: Input for the player's fee (feeSpinner).
Buttons: Trigger actions (e.g., registerButton for registering a player, displayButton for displaying registered players).
Text Area: Displays the list of registered players (textArea).
Scroll Pane: Allows scrolling of the text area (scrollPane).
# File Handling:
File: Represents the file where player data is stored (file).
FileWriter and BufferedWriter: Write data to the file (fWriter, bWriter).
FileReader and BufferedReader: Read data from the file (fReader, bReader).
# Event Handling:
Register ActionListener: Handles the registration of a new player by writing to the file (Register).
Display ActionListener: Handles the display of registered players by reading from the file (Display).
Check Class (Check)
Purpose: Represents a player with attributes name, position, preferred foot, and fee.
# Attributes:
name: The player's name.
position: The player's position.
feet: The player's preferred foot.
fee: The player's fee.
# Methods:
Getters and Setters for each attribute.
toString(): Returns a string representation of the player's attributes in the format name#position#feet#fee.
# How It Works
Initialization: When the application starts, an instance of the Player class is created, setting up the GUI.
#Registering a Player:
The user fills in the player's details in the text fields, combo boxes, and spinner.
When the "REGISTER" button is clicked, the Register ActionListener is triggered.
The player's details are collected, a Check object is created, and its string representation is written to the file.
#Displaying Players:
When the "DISPLAY" button is clicked, the Display ActionListener is triggered.
The file is read line by line, and the contents are displayed in the text area.
This application provides a simple interface for managing and viewing player information, storing data persistently in a text file
