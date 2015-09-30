# Emboss #
Send a PEF-file to an embosser for embossing.

One argument is required, and can be one of the following:
  * path to a file
  * `-clear`
  * `-setup`

Upon the first run, the application will ask the user for the required setup:
  * device
  * embosser model
  * embosser table (if applicable)
  * paper size

The file will be sent directly to the embosser on subsequent runs. To change settings, use either `-setup` or `-clear`.

## Setup ##
Setup will ask all the user to verify all settings.

## Clear ##
Clear will delete the current settings. The next time the application is started, it runs as on the first run.

## Device ##
The device is the address where the embosser can be contacted. In most cases this should be intuitive. If your device does not show up, make sure that the embosser is turned on.

## Embosser Model ##
Note that the same embosser model may communicate differently depending on firmware or hardware version. Make sure that the embosser version is correct.

## Embosser Table ##
Some embossers require that a table is chosen by the user for the purpose of communication. Make sure that the table chosen in the user interface matches the value expected by the embosser.

## Paper Size ##
Verify that the paper in the embosser matches the value in the user interface. Some embossers uses rolls of paper. In this case, select a paper size that matches the intended paper size once cut.