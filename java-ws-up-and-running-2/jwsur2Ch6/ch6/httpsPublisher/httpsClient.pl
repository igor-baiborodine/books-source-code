#!/usr/bin/perl -w

use Net::SSLeay qw(get_https);
use strict;

my ($type, $start_line, $misc, $extra) = get_https('localhost', 3443, '/test');
print "Type/value:  $type\n";
print "Start line:  $start_line\n";
print "Misc:        $misc => $extra\n";

