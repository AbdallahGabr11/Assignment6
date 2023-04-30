# Autosar Modulation Project

this program reads an ARXML file containing a list of containers, each with a unique ID, and                                                                       reorders the containers alphabetically by their name sub- container "SHORT-NAME"                                                                                       The program should write the reordered containers to a new ARXML file.

## Usage

To use the project, run the following command:                                                                                                                                
java project.Project input_file_name.arxml


where `input_file_name.arxml` is the name of the input Autosar file. The output file will be saved with the suffix `_mod` in the same directory as the input file.

## Exceptions

The project throws two types of exceptions:

- `NotVaildAutosarFileException`: if the input file extension is not `.arxml`
- `EmptyAutosarFileException`: if the input file is empty
