# Convert to HTML
asciidoctor -a toc -a numbered javaee7-hol.adoc

# Convert to PDF
asciidoctor -b docbook -a toc -a numbered -d book javaee7-hol.adoc
~/tools/asciidoctor-fopub-master/fopub javaee7-hol.xml

