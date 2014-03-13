robot-intellij-plugin
=====================

<h2>Robot IntelliJ Plugin for Java</h2>

<h4>Author: Charles Capps</h4>
<h4>Email: charles.capps@jivesoftware.com</h4>

<p>
IntelliJ Plugin to enable syntax highlighting and other features in Robot text files. Specifically designed with Java integration in mind.
</p>

version 1.0.1
------------
<ul>
<li>Added ability to go to definition of a Robot keyword that's defined in Java or a robot file.</li>
<li>Fixed some bugs in tokenizing. Robot keywrod definitions are now parsed separately from robot keywords.</li>
<li>Refactored to use a BNF file and generate the parser automatically. Trivial language at the moment, don't require much of a tree.</li>
<li>Improved performance by only searching for java keywords in the current module. </li>
</ul>




