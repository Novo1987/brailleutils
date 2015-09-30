# Repository Layout #
The trunk, tags, and branches directories live in the root directory of the repository, and the projects are placed in subdirectories beneath those.

  * braille
  * BrailleUtils
  * braille-utils.api
  * braille-utils.impl

## braille ##
**Note! This is the original project. We're in the process of moving this into other projects, and is no longer needed for compiling or running the project.**

## BrailleUtils ##
This is the application project and it contains the CLI and distribution build.

## braille-utils.api ##
This is the previous "core" code and contains the basic functionality. It will be restructured in the future for OSGi compatibility, and may be broken into smaller pieces.

## braille-utils.imp ##
This is the previous "catalog" code and contains all non-essential implementations, i.e. optional for using the "core" project's artifacts (i.e. interface implementations such as embossers and papers).

_The following paragraphs will be subject to revision in the near future, but are currently valid._

This project has a relatively flat source structure. Each folder should contain _related implementation entities_. Each entity should be modeled on the domain of an organization using a two-part underscore separated string where the first part begins with the top level domain name of the organization and then the organization's domain. If possible, use the organization of the provider of the hardware (or software) that the implementations target. If this is not possible, use the organization of the provider of the implementations (your organization).

Note that this does not imply ownership or responsibility for the code in the package, but merely serves as identification and a structuring aid.

The classes in each of these folders should be considered package specific. Implementations may not rely on other packages in the project. If a functionality can be regarded as _generic_, it should be placed in the core project instead.