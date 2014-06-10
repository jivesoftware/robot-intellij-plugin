robot-intellij-plugin
=====================

<h2>Robot IntelliJ Plugin for Java</h2>

<h4>Author: Charles Capps</h4>
<h4>Email: charles.capps@jivesoftware.com</h4>

<p>
IntelliJ Plugin to enable syntax highlighting and other features in Robot text files. Specifically designed with Java integration in mind.
See http://plugins.jetbrains.com/plugin/7430?pr=idea for the newest version or download it from within IntelliJ!
</p>

<h3>Version 1.1.6</h3>
<ul>
<li>
Performance improvements - use the Java Stub Index to search for methods when we're searching by the exact name.
Use the word index when searching for Robot keyword definitions in Robot files.
Found one case where unnecessary work may have been done.
This should improve performance for large projects that have many Robot files.
Next improvement would be to implement a StubTree and StubIndex.
</li>
</ul>

<h3>Version 1.1.5</h3>

<ul>
   <li>
      Fix a regression--accidentally compiled on Linux with Java 1.7 targeting Java 1.6, which makes it not work
      on Mac with IntelliJ Ultimate edition. Jetbrains--please fix this if possible? 
   </li>
</ul>

<h3>Version 1.1.4</h3>

<ul>
    <li>Add support for Rename Refactoring! You can rename Keywords defined in Java or Robot and the change will
    propagate to all usages of the Keyword!</li>

    <li>Fix bug with Autocomplete listing duplicate entries, and improved autocomplete.</li>

    <li>Implemented Structure View to list all Test Cases and Keyword definitions in a Robot file.</li>
</ul>

<h3>Version 1.1.3</h3>

<ul>
    <li>Fix a regression where the plugin didn't work in Ultimate edition.</li>
</ul>

<h3>Version 1.1.2</h3>
<ul>
    <li>Added the ability to find Test Cases with Go To Symbol, i.e. with the hotkey Ctrl+shift+alt+n.</li>
</ul>

<h3>Version 1.1.1</h3>

<ul>
    <li>Fixed a bug with tag auto-completion from version 1.1.0.</li>
</ul>

<h3>Version 1.1.0</h3>

<ul>
    <li>Added full syntax error highlighting support! The Robot language is now fully parsed!</li>
    <li>Common Robot errors will be caught before runtime, such as assigning a variable to a String instead of a Keyword.</li>
    <li>Fixed a minor bug where Autocomplete would suggest lowercase Java methods.</li>
    <li>Fixed a minor bug where Autocomplete suggestions would not have spaces between words where appropriate.</li>
</ul>

<h3>Version 1.0.6</h3>
<ul>
    <li>Added templates so you can create a Robot Test Case File or Robot Keywords File from the New menu in the project explorer.</li>
    <li>Explicitly declaring dependencies on "lang" and "java" modules.</li>
    <li>Hoping above change will cause this plugin to be suggested when you open a Robot file and it says "Plugins supporting files with *.robot extension are found".</li>
</ul>

<h3>Version 1.0.5</h3>
<ul>
	<li>Fixed a major bug that apparently was causing many features to not work for Mac, because Robot files were never indexed. In Ubuntu, I didn't notice any
            problems. The RobotKeywordUsagesProvider has to return a new WordsScanner each time getWordsScanner() is invoked, unless
            the given scanner is thread-safe.
    </li>
    <li>Yay, no more error messages in the event log!</li>
    <li>Added the .iml file to git, so it's easier to start working on the project.</li>
</ul>

<h3>Version 1.0.4</h3>
<ul>
    <li>Fixed a bug where keywords defined within Robot would appear twice in autocomplete.</li>
</ul>

<h3>Version 1.0.3</h3>
<ul>
    <li>You can find usages of Java-defined Robot Keywords. It will find all usages in Robot files + Java</li>
    <li>(Hopefully) fixed a bug where not all tokens were parsed in a Robot file by the words scanner for indexing.</li>
    <li>Added plugin JAR to the bin folder for easy download if you don't want to setup your environment for plugin development and compile it.</li>
</ul>

<h3>Version 1.0.2</h3>
<ul>
    <li>You can find usages of Robot keywords defined in Robot files.</li>
    <li>Autocomplete works to suggest Robot keywords as you type---and it includes robot keywords from Java methods or Robot files</li>
    <li>Reworked how searching is done in RobotKeywordDefinitionFinder. Searches by the method name against the word index when possible.
      When not possible, searches by the term "RobotKeyword" in java files, since we're are only dealing with robot keywords defined in Java
      with the @RobotKeyword annotation.
    </li>
    <li>Autocomplete robot tags as well.</li>
</ul>

<h3>Version 1.0.1</h3>
<ul>
    <li>Added ability to go to definition of a Robot keyword that's defined in Java or a robot file.</li>
    <li>Fixed some bugs in tokenizing. Robot keyword definitions are now parsed separately from robot keywords.</li>
    <li>Refactored to use a BNF file and generate the parser automatically. Trivial language at the moment, don't require much of a tree.</li>
    <li>Improved performance by only searching for java keywords in the current module. </li>
</ul>







