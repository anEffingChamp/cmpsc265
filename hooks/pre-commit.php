#!/usr/bin/env php
<?php
foreach (glob(__DIR__ . '/../8/*.java') as $element) {
    $element = substr($element, 0, -5);
    var_dump($element);
    $output = shell_exec("javac $element.java && java $element");
    exit;
}
