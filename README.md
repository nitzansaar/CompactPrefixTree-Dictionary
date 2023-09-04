# CompactPrefixTree Dictionary Project

The CompactPrefixTree Dictionary is an implementation of the Dictionary ADT (Abstract Data Type) using a compact prefix tree data structure. This data structure is used to efficiently store and manage a collection of words, making it suitable for tasks such as spell checking, autocomplete, and suggestions. The project includes the implementation of the CompactPrefixTree class, a Driver class for testing, and additional utility methods.

## CompactPrefixTree Class

The `CompactPrefixTree` class implements the Dictionary ADT and provides methods for adding words, checking if a word exists, checking if a prefix exists, and suggesting similar words. The class includes a private `Node` inner class to represent nodes in the compact prefix tree.

### Key Methods

- `add(String word)`: Adds a given word to the dictionary.
- `check(String word)`: Checks if a given word is in the dictionary.
- `checkPrefix(String prefix)`: Checks if a given prefix exists in the dictionary.
- `suggest(String word, int numSuggestions)`: Returns an array of suggestions for a given word.

### Additional Methods

- `toString()`: Provides a human-readable representation of the compact prefix tree.
- `printTree(String filename)`: Prints the tree's structure to a file with specified indentations.
- Private helper methods for supporting the core functionality.

## Driver Class

The `Driver` class is used to test the functionality of the `CompactPrefixTree` class. It demonstrates how to use the methods provided by the dictionary, and includes test cases for different scenarios such as checking words, prefixes, and suggesting similar words.

## Getting Started

1. Clone the repository or download the source files.
2. Compile the source files using a Java compiler.
3. Run the `Driver` class to see the tests and results.

## Usage

1. Create an instance of the `CompactPrefixTree` class.
2. Use the `add`, `check`, `checkPrefix`, and `suggest` methods to interact with the dictionary.
3. View the output and test results in the console.

## What I Learned

Throughout this project, I learned important concepts related to data structures, algorithms, and software design, including:

- **Compact Prefix Tree**: Understanding the design and implementation of a compact prefix tree data structure for efficient word storage and retrieval.
- **Recursive Algorithms**: Implementing recursive algorithms to traverse and manipulate the compact prefix tree.
- **String Processing**: Utilizing string manipulation techniques to compare and extract prefixes and substrings.
- **Test-Driven Development**: Writing test cases using the Driver class to ensure the correctness of the methods and their behavior.
- **Code Organization**: Designing and organizing classes and methods to create a well-structured and maintainable codebase.

By working on this project, I gained hands-on experience in building a specialized data structure for dictionary-related tasks, enhancing my skills in algorithmic thinking, debugging, and creating functional software.

## Project Structure

The project includes the following files:

- `CompactPrefixTree.java`: Implementation of the CompactPrefixTree class.
- `Driver.java`: Driver class to test the CompactPrefixTree functionality.