# Neighborhood Sports Preferences Simulation

A Java-based cellular automaton that models how sports preferences spread through a neighborhood over time. Each household on a grid updates its preference monthly based on the preferences of its neighbors, similar in concept to Conway's Game of Life, but with richer, sport-specific evolution rules.

---

## What it does

The simulation runs on an NxN grid where each cell represents a household with one of seven states:

| Symbol | Preference |
|--------|------------|
| `A` | Baseball |
| `B` | Basketball |
| `F` | Football |
| `R` | Rugby |
| `S` | Soccer |
| `E` | Everything (all sports) |
| `N` | Nothing (no interest) |

Each month, every household surveys its immediate neighbors (up to a 3x3 grid) and applies its own rule set to determine its state for the next month. Interest levels (0-5) add another dimension, allowing households to become more or less enthusiastic before flipping to a different sport entirely.

The grid can be initialized randomly or loaded from a file, and the simulation runs for a user-specified number of months.

---

## Technical highlights

- **OOP class hierarchy**  abstract base classes (`Household`, `SportsHouseholds`), interface (`InterestLevel`), and 7 concrete household types, each encapsulating its own update logic
- **Enum-driven state**  sports preferences modeled as a `Sports` enum for type safety
- **Immutable update step**  each month produces a new grid from the old one (no in-place mutation), avoiding update-order bugs
- **File I/O**  grids can be saved and loaded from text files for reproducible runs
- **JUnit 5 test suite**  unit tests for each household type covering edge cases in the neighbor-based rules

---

## How to run

**Prerequisites:** Java 11+, Maven

```bash
# Clone the repo
git clone https://github.com/Alex-brav/neighborhood-sports-simulator.git
cd neighborhood-sports-simulator

# Build
mvn compile

# Run
mvn exec:java -Dexec.mainClass="com.alexbrav.sportsim.Neighborhood"
```

You'll be prompted to choose between a random grid or loading from a file, then enter the grid size and number of months to simulate.

**Run tests:**
```bash
mvn test
```

---

## Example output

```
Initial grid:
A4 E  A3 N  F0 N  A1 R2
E  E  S4 E  A1 E  S0 A3
E  F4 A3 S3 B4 B4 B4 E
...

Updated grid for month 1:
R0 B2 R0 E  A0 E  A2 A4
B2 B2 S5 B2 R0 B2 E  A4
...
```

---

## Project background

Built as a course project to practice object-oriented design in Java - specifically abstract class hierarchies, interface contracts, and simulation loop architecture. The rule system (7 household types x multiple prioritized conditions each) required careful separation of concerns to keep each class self-contained and testable.

---

## Possible extensions

- Visualize the grid evolution with a simple Java Swing GUI
- Add a web frontend to watch the simulation animate in real time
- Port the simulation engine to Python and experiment with ML-based rule learning

---

## License

MIT
