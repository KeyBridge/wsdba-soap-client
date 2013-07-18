#  Key Bridge Peering Service 
#  Test SOAP Client 
 
##  About  
  
This is a simple NetBeans project containing the minimal SOAP client implementation
necesary to access the Key Bridge SOAP Peering Service Supporting the WSBDA Data Specification.

The Key Bridge SOAP Peering Service implements username authentication with
symmetric keys for integrity and confidentiality protection.

## Dependencies
The project makes reference to an external LIB-WSDBA, which is a compiled implementation
of the software objects defined within or references by the WSDBA Data Specification.
You must provide this yourself.

For testing purposes you may remove this external reference and compile the facaded class 
descriptions within the WSDL.
  
##  Configuration
  
### Username and Password
Prior to accessing the SOAP service you you must first update the file 'WSDBASoapService.xml', 
located in the META-INF directory, and enter your Key Bridge issued username and password in the
sc:CallbackHandler "usernameHandler" and "passwordHandler" elements near
lines 50 and 51 of that file.
  
### Security Credentials: 
Java METRO also requires a JKS TrustStore to establish an SSL connection. 
Other languages may have different requirements. A sample TrustStore named
 'keystore.jks' is provided for you in the root source 'src' directory. 
 Move this file to your desired location (e.g. a temporary directory) and 
 update the 'WSDBASoapService.xml' file 'sc:TrustStore' entry near line 53 to
  point to the keystore.jks file location that you moved on to your local file system.

## References / Requires:
  [METRO]: https://metro.java.net/
  Metro is a high-performance, extensible, easy-to-use web service stack.

## GNU General Public License
> This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
> This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.

_END
