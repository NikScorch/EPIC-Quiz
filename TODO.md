# TODO
- Add security check to `build.sh`
 - Check run directory matches a hash corrolating to the expected project directory
- In `build.sh` extract .dll and .so to a temp new *directory* with a unique/set UUID rather than the root of $TEMP
- Add logic to Main.java to load either .so or .dll files depending os type
- Fix linux dependency loading in Main.java