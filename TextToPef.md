# Text to PEF #
Convert a text braille file into a PEF-file.

Two arguments are required _path to input file_ and _path to output file_.

The input file should be a "braille ready" text file, i.e. broken in rows an pages (using the form feed character), and using one unique character to represent each braille pattern.

<pre>
Example:<br>
java -jar brailleUtils-ui.jar text2pef input.txt output.pef<br>
</pre>

Optional arguments include:
  * mode
  * identifier
  * date
  * author
  * title
  * language
  * duplex

The options `identifier`, `date`, `author`, `title` and `language` all involve setting the meta data of the resulting file. It will not affect the contents of the file in any way.

<pre>
Example:<br>
java -jar brailleUtils-ui.jar text2pef input.txt output.pef -date=2013-01-01<br>
</pre>

## Mode ##
Choose a table to use when converting. Note that, if a character is encountered in the file that isn't in the selected table, an error will occur. The default mode is to attempt to detect. If this fail, choose between the tables suggested in the detector failure message.

<pre>
Example:<br>
java -jar brailleUtils-ui.jar text2pef input.txt output.pef -mode=nabcc<br>
</pre>

## Duplex ##
Set the duplex property of the resulting file.

<pre>
Example:<br>
java -jar brailleUtils-ui.jar text2pef input.txt output.pef -duplex=true<br>
</pre>