# 📦 Search Inventory App

Welcome to the **Search Inventory App** – a simple command-line tool for managing and searching product inventories stored in a CSV file. Whether you need to browse all items, look up a product by ID, or filter products within a price range, this app makes it quick and easy.

## 🧠 What This App Does

This Java application allows you to:

- 📝 List all products in the inventory
- 🔍 Search for a product by its ID
- 💰 Find products within a specified price range
- ➕ Add a new product to the inventory
- ❌ Exit the application

All data is stored in a simple CSV file (`inventory.csv`) using a pipe (`|`) delimiter.

## 🛠️ Technologies Used

- **Java 24**
- **Scanner** for CLI input
- **FileReader & FileWriter** for file I/O
- **Exception Handling** for robust user input

## 📂 Project Structure
```
.
├── src/
│   └── com/
│       └── pluralsight/
│           ├── Menu.java
│           ├── Product.java
│           ├── ProductService.java
│           └── SearchInventoryApp.java
├── src/main/resources/
│   └── inventory.csv
```
## 📋 Sample CSV Format

The inventory file (`src/main/resources/inventory.csv`) follows this format:

```
    $ cat src/main/resources/inventory.csv
    1|Keyboard|49.99
    2|Mouse|19.99
    3|Monitor|129.99
```

## ⚙️ Features In Detail

- **Menu Navigation**  
  Simple numbered menu with clear options.

- **Input Validation**  
  Handles invalid inputs gracefully with helpful error messages.

- **CSV I/O**  
  Reads and writes to a file using pipe `|` as a delimiter.

- **Extensibility**  
  Easy to expand with more features (e.g., edit/delete).

## 🚀 Future Improvements

- [ ] Support for editing or deleting products
- [ ] Sorting options for display
- [ ] UI enhancements or GUI version
- [ ] Persistent ID generation

## 🙌 Credits

- **Main Developer**: [Paulo Cunha](https://github.com/paulofranklins2) – Developer and creator of this project.