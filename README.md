![MIT License](/img/MIT.png "MIT")

<details>
  <summary>License</summary>

**MIT License © 2025 Aerosimo**

Permission is hereby granted, free of charge, to any person obtaining a copy  
of this software and associated documentation files (the "Software"), to deal  
in the Software without restriction, including without limitation the rights  
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell  
copies of the Software, and to permit persons to whom the Software is  
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all  
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR  
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,  
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE  
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER  
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,  
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  
SOFTWARE.

The characters, names, events, articles, templates, or information provided by  
Aerosimo Ltd are fictional and for reference only. While we strive to keep the  
information up to date and correct, we make no representations or warranties of  
any kind, express or implied, about the completeness, accuracy, reliability,  
suitability, or availability with respect to the information, articles, templates,  
or related graphics contained in this document or any part of the project.  
Any reliance you place on such information is therefore strictly at your own risk.
</details>

---

![Project Cover](/img/cover.jpg "Astrology")
# Stratum
> *Reflects the layered rules behind card number generation. Validating a credit card refers to the process of running a computer algorithm
> that performs calculations using a credit card's number.
> When the algorithm shows that the card is valid, it means only that the card number
> is among those that could potentially exist with a given credit card company.
> For example, a random series of numbers would likely result in an invalid answer
> from the program, while an actual card number, even from a card that has expired
> or reached its credit limit, would show up as valid, since the number is one that
> the credit card company issued.*

---

## Project Structure

This `README.md` gives an overview of the project structure and instructions on how to build and deploy the application.

## Features

**SOAP & REST Web Service**: Exposes a `verify(String CardLongNumber)` method to retrieve daily horoscope and store it in the database.

## Getting Started

![Project Codes & Tasks](/img/code.jpg "Project Codes and Task")

---

### Prerequisites

>- **Apache TomEE 10**: is the application server used during development, but any Jakarta EE 10-compliant server should work.
>- **Java 25**: Ensure you have Java 25 installed as TomEE 10 targets Jakarta EE 10.
>- **Maven**: The project uses Maven for dependency management with any IDE of choice.

### Dependencies

The required dependencies are defined in `pom.xml`. Below are the key dependencies:

- **Jakarta EE 10 API**: Provides JAX-WS support.
- **JAX-WS**: For SOAP web service implementation.
- **JAX-RS**: For REST web service implementation.

### Building and Running the Application

## Quickstart

1. **Clone the repository**:

    ```bash
    git clone https://github.com/aerosimo/stratum.git
    cd stratum
    ```

2. **Build the project using Maven**:

    ```bash
    mvn clean install
    ```

3. **Deploy the WAR file**:

   After building the project, deploy the generated `WAR` file from the `target/` directory into the `webapps/` folder of your preferred Jakarta EE 10-compatible server.

4. **Start your preferred Jakarta EE 10-compatible server**:

   Start server and access the application:

    - SOAP Service: WSDL at `http://localhost:8081/stratum/ws/stratum?wsdl`
    - REST Service: http://localhost:8081/stratum/api/stratum/validateCard/cardnumber
    - Web Interface: `http://localhost:8081/stratum/index.jsp`

## Detailed Explanation of Components

### 1. **SOAP Web Service** (JAX-WS)

The SOAP web service is implemented in `com.aerosimo.ominet.stratum.api.soap.StratumSOAP.java`.

Example sendMail SOAP Request:
```xml
<?xml version='1.0' encoding='UTF-8'?>
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:ast="https://aerosimo.com/api/ws/astrology">
    <soap:Header/>
    <soap:Body>
        <ast:sendEmail />
    </soap:Body>
</soap:Envelope>
```
### 2. **REST Web Service** (JAX-RS)

The REST web service is implemented in `com.aerosimo.ominet.astrology.api.rest.AstrologyREST.java`.

Example horoscope REST Request:
```curl
POST http://localhost:8081/astrology/api/astrology/horoscope

```
Example sendMail REST Response:
```json
    {
      "status": "success",
      "message": "Daily horoscope update initiated."
    }
```

```
## Contributing

We welcome feedback and contributions. Please open an issue or submit a pull request.

```

![Aerosimo Logo](/img/logo.png "Aerosimo")