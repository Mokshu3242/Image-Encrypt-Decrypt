## Image Encryption and Decryption (Java Project)

### Overview
The Image Encryption and Decryption project is a Java-based desktop application that uses XOR operations to encrypt and decrypt images, allowing users to control image access with a numeric key.

### Features
* **Image Encryption/Decryption**: Uses XOR operations to scramble and restore pixel values.
* **User-Friendly GUI**: Java Swing-based interface for selecting encryption or decryption options.
* **Secure Access**: Only users with the correct key can decrypt images.

### File Structure
* `App.java`: Main GUI application for selecting encryption or decryption.
* `Imageen.java`: Encrypts the chosen image with a specified numeric key.
* `Image.java`: Decrypts the encrypted image using the correct numeric key.

### Installation

#### Prerequisites
* Java Development Kit (JDK) 11 or higher
* Java IDE: Eclipse, IntelliJ IDEA, or any Java-compatible IDE

#### Steps
* Clone the repository:
   ```bash
   git clone https://github.com/yourusername/image-encryption.git
   ```
* Open in IDE:
   Open the project in your preferred IDE (e.g., Eclipse or IntelliJ IDEA).

* Run:
   Execute `App.java` to launch the GUI.

### Usage
* Select Encryption or Decryption:
   * Choose an image and enter a numeric key.
   * Encrypt or decrypt the image based on the selected option.
