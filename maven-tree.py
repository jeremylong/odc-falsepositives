## mvn dependency:tree -DoutputFile=./target/tree.txt
## mvn org.owasp:dependency-check-maven:6.5.0:check -Dformats=HTML,JSON
## python3 maven-tree.py ./target/tree.txt ./target/dependency-check-report.json > ./target/odc_tree.html
import json
import sys
import re

if len(sys.argv) != 3:
    sys.exit("Missing path to dependency:tree report and/or the odc json report")

jsonpath = sys.argv[2]
with open(jsonpath, "r") as f:
    data = json.load(f)

treepath = sys.argv[1]
with open(treepath, "r") as f:
    content = f.read()
dep_tree = content.splitlines();
output = ['<html>','<body>','<pre>']

for d in dep_tree:
    added=False
    link=''
    for row, i in enumerate(data['dependencies']):
        found=False
        if ('vulnerabilities' in i):
            if ('packages' in i):
                for id in i['packages']:
                    m = re.match(r'pkg:maven/(?P<group>[^/]+)/(?P<artifact>[^@]+)@(?P<version>[0-9A-Z.-]+)',id["id"])
                    if m:
                        gav=m.groupdict()
                        if f'{gav["group"]}:' in d and f'{gav["artifact"]}:' in d and f'{gav["version"]}:' in d:
                            found=True
                if found:
                    link = f'<a href="./dependency-check-report.html#l{row+1}_{i["sha1"]}">{len(i["vulnerabilities"])} vulnerabilities</a>'
        if found:
            output.append(f'{d} {link}')
            added=True
    if not added:
        output.append(d);

output.append('</pre></body></html>')

print('\n'.join(output))