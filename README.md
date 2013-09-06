#  Key Bridge WSDBA Peering Service
#  Test SOAP Client

##  About

This is a simple NetBeans project containing the minimal SOAP client implementation
necessary to access the Key Bridge SOAP Peering Service Supporting the WSBDA Data Specification.

## Dependencies
The project makes reference to an external LIB-WSDBA, which is a compiled implementation
of the software objects defined within or references by the WSDBA Data Specification.
You must provide this yourself.

For testing purposes you may remove this external reference and compile the facaded class
descriptions within the WSDL.

##  Configuration

As of 09/06/13 Username and Password authentication has been removed from the SOAP service.
The client program should run out-of-the box with no modification. Please contact us if you
encounter any issues or errors.

## References / Requires:
[METRO]: https://metro.java.net/
This SOAP client uses Java Metro.Metro (https://metro.java.net) is a high-performance,
extensible, easy-to-use web service stack.

## GNU General Public License
> This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
> This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.

_END
