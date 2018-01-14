#!/usr/bin/perl -w

use SOAP::Lite +trace => 'debug';
use strict;

my $url = 'http://localhost:9876/ski?wsdl';   
my $service = SOAP::Lite->service($url);     
$service->getImage("nordic");
