# Island Mapper

Island Mapper is a Java application designed for interactive visualization and analysis of islands on a grid-based map. The application provides a graphical interface where users can mark areas as islands on a 9x9 grid, calculate their area and perimeter, and count the total number of distinct islands using Depth-First Search (DFS) algorithms.

## Features

- **Interactive Grid:** A 9x9 grid for marking islands and visualizing data.
- **Calculations:** Compute the area, perimeter, and number of islands.
- **Graphical Representation:** Color-coded grid cells to represent islands.
- **Educational Value:** Demonstrates algorithms like DFS for graph traversal.
- **User-Friendly GUI:** Built with Java Swing for a smooth experience.

## Requirements

To run Island Mapper, you need:

- Java Development Kit (JDK)
- Java Runtime Environment (JRE)
- Swing library for GUI components

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/IslandMapper.git
    ```
2. Navigate to the project directory:
    ```bash
    cd IslandMapper
    ```
3. Compile the Java file:
    ```bash
    javac Islands.java
    ```
4. Run the application:
    ```bash
    java Islands
    ```

## Usage

1. Launch the application.
2. Use the 9x9 grid to mark cells as part of an island by clicking them.
3. Click the following buttons for analysis:
   - **Area:** Calculate the total area of marked islands.
   - **Perimeter:** Compute the perimeter of marked islands.
   - **Number of Islands:** Count distinct islands using DFS.
4. View results in the text field at the top of the application.

## Code Highlights

The core functionalities include:

- **DFS Algorithm:**
    ```java
    void dfs(int[][] map, int i, int j) {
        if (i < 0 || j < 0 || i >= map.length || j >= map[0].length || map[i][j] != 1) {
            return;
        }
        map[i][j] = -1; // Mark visited
        dfs(map, i + 1, j);
        dfs(map, i - 1, j);
        dfs(map, i, j + 1);
        dfs(map, i, j - 1);
    }
    ```

- **GUI Components:** Built using Java Swing for a user-friendly interface.

## Advantages

- Intuitive and interactive interface.
- Demonstrates practical implementation of graph algorithms.
- Suitable for educational and recreational purposes.

## Limitations

- Fixed grid size (9x9).
- Single-threaded execution.
- Dependency on Java Runtime Environment (JRE).

## Contribution

Contributions are welcome! Please fork the repository and submit a pull request with your changes.

## License

This project is licensed under the [MIT License](LICENSE).

## Contact

For any inquiries or feedback, feel free to reach out:

- **Author:** Harshil Amin

