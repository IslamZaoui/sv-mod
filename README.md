![banner](./readme-banner.webp)

# Soviet Union meme Mod

Yet another trolling mod that embraces the soviet union.

## Disclaimer

this is just a mod for trolling and having fun, I'm not even a Russian or communist.

have fun with this mod and don't use it inappropriately.

## Inspiration

I want to make this meme I saw on Instagram reel come true.

you can watch it [here](https://www.instagram.com/p/C4x2NgqMQeB/)

## Features

- craftable soviet union flag item that can play the soviet union national anthem.
- works in multiplayer.

## To do List

- [ ] adding a custom golden hammer, sickle, and star.
- [ ] adding custom mobs that drop golden hammer, sickle, and star.
- [ ] adding a custom Minecraft banner with a communism symbol.
- [ ] adding custom effects and mechanisms to the flag.

## Installation

### Modrinth

My mod is available in [modrinth](https://modrinth.com/), install it from [here](https://modrinth.com/mod/soviet-union-meme-mod).

### Manually

1. Download and run the [Fabric installer](https://fabricmc.net/use).
   - Note: this step may vary if you aren't using the vanilla launcher
     or an old version of Minecraft.
1. Download the [Fabric API](https://minecraft.curseforge.com/projects/fabric)
   and move it to the mods folder (`.minecraft/mods`).
1. Download this from the [releases page]($repo_url/releases)
   and move it to the mods folder (`.minecraft/mods`).

## Contributing
1. Clone the repository
   ```
   git clone https://github.com/islamZaoui/sv-mod
   cd sv-mod
   ```
1. Generate the Minecraft source code
   ```
   ./gradlew genSources
   ```
   - Note: on Windows, use `gradlew` rather than `./gradlew`.
1. Import the project into your preferred IDE.
   1. If you use IntelliJ (the preferred option), you can simply import the project as a Gradle project.
   1. If you use Eclipse, you need to `./gradlew eclipse` before importing the project as an Eclipse project.
1. Edit the code
1. After testing in the IDE, build a JAR to test whether it works outside the IDE too
   ```
   ./gradlew build
   ```
   The mod JAR may be found in the `build/libs` directory
1. [Create a pull request](https://help.github.com/en/articles/creating-a-pull-request)
   so that your changes can be integrated into $mod_name
   - Note: for large contributions, create an issue before doing all that
     work, to ask whether your pull request is likely to be accepted
