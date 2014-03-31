robot-intellij-plugin
=====================

<h2>Robot IntelliJ Plugin for Java</h2>

<h4>Author: Charles Capps</h4>
<h4>Email: charles.capps@jivesoftware.com</h4>

<p>
IntelliJ Plugin to enable syntax highlighting and other features in Robot text files. Specifically designed with Java integration in mind.
</p>

Version 1.0.1
-------------
<ul>
    <li>Added ability to go to definition of a Robot keyword that's defined in Java or a robot file.</li>
    <li>Fixed some bugs in tokenizing. Robot keyword definitions are now parsed separately from robot keywords.</li>
    <li>Refactored to use a BNF file and generate the parser automatically. Trivial language at the moment, don't require much of a tree.</li>
    <li>Improved performance by only searching for java keywords in the current module. </li>
</ul>


Version 1.0.2
-------------
<ul>
    <li>You can find usages of Robot keywords defined in Robot files.</li>
    <li>Autocomplete works to suggest Robot keywords as you type---and it includes robot keywords from Java methods or Robot files</li>
    <li>Reworked how searching is done in RobotKeywordDefinitionFinder. Searches by the method name against the word index when possible.
      When not possible, searches by the term "RobotKeyword" in java files, since we're are only dealing with robot keywords defined in Java
      with the @RobotKeyword annotation.
    </li>
    <li>Autocomplete robot tags as well.</li>
</ul>

Version 1.0.3
-------------
<ul>
    <li>You can find usages of Java-defined Robot Keywords. It will find all usages in Robot files + Java</li>
    <li>(Hopefully) fixed a bug where not all tokens were parsed in a Robot file by the words scanner for indexing.</li>
</ul>


