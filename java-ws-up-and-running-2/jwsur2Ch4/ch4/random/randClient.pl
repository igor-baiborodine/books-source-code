#!/usr/bin/perl -w

use SOAP::Lite +trace => 'debug';
use strict;

my $soap = 
    SOAP::Lite->uri('http://rand/')->proxy('http://localhost:8888/rs/');
my $num = $soap->next1()->result();
print "Response is: $num\n";

