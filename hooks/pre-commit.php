#!/usr/bin/env php
<?php
foreach (glob(__DIR__ . '.java') as $element) {
    $element = substr($element, 0, -5);
    $output = shell_exec("javac $element.java && java $element");
}
