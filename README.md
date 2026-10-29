# File System Visitor — Software Design Patterns

This project is an individual assignment for the **Software Design Patterns** course (Astana IT University). It demonstrates the practical implementation of the **Visitor behavioral design pattern** in Java using the double-dispatch mechanism.

## 📁 Project Structure

The project models a simple hierarchical file system structure:
* **Elements (`FileSystemElement`):**
  * `File` — represents an individual file with a name and size.
  * `Directory` — represents a folder containing other files and sub-directories.
* **Visitors (`FileSystemVisitor`):**
  * `PrintTreeVisitor` — prints the hierarchical file system tree structure.
  * `SizeCalculatorVisitor` — calculates the total size of all files in the system.
  * `SearchVisitor` — searches for files matching a specific criterion (e.g., `.java` extension).

## 🛠️ Technical Requirements
* **Language:** Java (JDK 17)
* **IDE Recommended:** IntelliJ IDEA
* **Design Pattern:** Visitor (Double Dispatch)

## 🚀 How to Run

1. Open the project in **IntelliJ IDEA**.
2. Navigate to `src/visitor/Main.java`.
3. Run the `main` method to see the execution of all three visitors (Tree structure printing, Total size calculation, and File searching).

## 💡 Key Design Highlights
* **Double Dispatch:** Fully replaces `instanceof` and type-checking chains, allowing new operations to be added without modifying existing element classes (`File` and `Directory`).
* **Single Responsibility Principle:** Each concrete visitor implements a single, well-defined operation across all element types.
