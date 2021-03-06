# Infinispan Documentation mini-sprint

28-30.07.2016

## General Notes
* Read documentation aloud to ensure the sentences flow
* Don’t take background concepts for granted, but also don’t repeat information. Link to existing explanations.
* Order is important: if a concept builds on other concepts it should come after them. Forward linking should be a last resort
* A picture / code-snippet / example are worth a thousand words (but always provide further explanation about meanings)
* If you include a code-snippet ensure it is valid code (i.e. it should compile) and that it works against the version being documented.
* Chapter titles should be as succinct as possible
*  Be consistent with terminology / hyphenation / character case
* Never include “Infinispan” in the chapter title unless absolutely necessary
* The correct spelling of Hot Rod is as two separate words.
* Remove documentation which doesn’t apply anymore.
* Ensure that links work, i.e. the targets exist
* Ensure that links between documents are relative to the current version. Absolute links to specific versions and to the “dev” and “stable” placeholders MUST not exist
* Ensure that links that need to be versioned use the {infinispanversion} asciidoc macro
* Replace the “sid-XXXX” anchors with meaningful ones
* Ensure that references to the current Infinispan version use the correct placeholder
* Maybe add annotator.js support so users can comment directly on the document like a PR review

## Image guidelines
* Prefer SVG when possible as it is very compact and provides the best scalability
* Alternatively use PNGs with indexed colors (don’t use full RGB images), with reasonable sizes and cleaned up with pngcrush
* Avoid gradients / backgrounds in bitmap formats
* Always add a caption

## Getting Started (Sebastian)
* This document is woefully full of TODOs. If we cannot DO them, they should be removed
* It should refer to existing tutorials where possible instead of duplicating information
* It should contain some of the information from the containerized tutorials
* Prefer REPL examples using jjs as it comes out-of-the-box in Java 8

## User Guide (All)

### Introduction (Tristan)
* We should add an introduction chapter, outlining what Infinispan is and why you would use it.

### Configuration (Tristan)
* Clean up / reorganize
* Always provide both a programmatic and declarative example for each configuration.
* Provide use-case-driven examples ?
* Add information about configuration templates and inheritance
* Rewrite the migration section: we only support migration from our old format to the new one

### Cache / CacheManager APIs (Galder)
* Remove the false claim of supporting the JCache API in our Cache interface
* Link alternative APIs (JCache, Spring, Functional)
* We should move the Cluster Executor documentation to the chapter about Distributed Execution and document why we have both (Will)

### Cache features
* The general organization of the document is very uneven in discussing configuration features (eviction, persistence) and API features at the same level. These chapters should be reorganized so that configuration features are grouped separately from APIs.

### Marshalling (Galder)
* With the ongoing work to remove the dependency on JBoss Marshalling for internals, and aiming to have a fully pluggable user marshaller, this will need to be rewritten in the context of Galder’s PRs
* Possibly show how one would write an externalizer which supports backwards/forwards compatibility

### Clustering (Dan)
* Transactions (Pedro)
* The Total Order docs should be moved under here

## Locking and concurrency (Pedro)
* The Versioning paragraph mentions tombstones as if they exist.

### Local mode cache (Radim)
* The simple cache documentation is erroneously included in the functional map API chapter. Move it here
* Update the information inside the performance paragraph to include results from the simple cache benchmarks

### Query + Indexing (Adrian & Gustavo)
* Add missing parts (CQ)

### Consistency guarantees (Dan)
* Refactor the WIKI page into the documentation, possibly as its own chapter.

### Streams (Will)
* In the serialization section mention the implicit overloading of lambdas to serializable
* Also provide an example of how one would implement an AdvancedExternalizer

### Map/Reduce (Vladimir)
* This feature no longer exists, it needs to go.

### CDI (Sebastian)
* Move under an overarching Integrations chapter
* Make sure we mention split artifacts (embedded and remote)
* Prevent mentioning configuration overriding 2 times (one for embedded and one for remote)

### Spring (Sebastian)
* Move under an overarching Integrations chapter
* Move to its own paragraph under Integrations
* Do not mention EHCache… it’s not relevant
* Mention proper artifacts (spring4)

### Remote Protocols (Tristan)
* The chapter is currently called “Server modules” but this is confusing as we are really discussing the remoting protocols and neither the WildFly modules nor Infinispan Server
* This should be turned upside down, looking at the protocol side first, and then detailing the server-side implementation aspects.

### Management Tooling (Vittorio)
* Remove the RHQ section and other mentions of it
* Move the CLI chapter under here

### Custom Interceptors (Dan)
* Since we are describing an advanced API this needs to be moved further up
* Document the new async design and provide some useful examples

### Running on AWS (Sebastian + Gustavo)
* Actually refactor this chapter into a more general chapter about running in different cloud/container environments
* AWS
* Docker
* OpenShift / Kubernetes
* Google Compute Engine
* Azure
* ...

### WildFly Modules (Gustavo)
* Move under an overarching Integrations chapter

### Default values for properties (Ryan)
* Remove this chapter and find a way to generate the information into the configuration reference

### HTTP session clustering and caching (Sebastian)
* Move under an overarching Integrations chapter
* Remove the  open tasks
* Mention Spring Session
* Eventually will also contain Paul’s Tomcat adapter

### JCache
* Move under an overarching Integrations chapter
* Remote JCache configuration, example of properties (at least IP:port)

### Second level cache guide (Galder)
* Place under Integrations


## Server Guide (Tristan)

### Console (Vladimir)
* The console should get a dedicated chapter outlining the different parts (Clusters, Nodes, Caches, Configuration)
* Don’t go overboard with screenshots
* Reference the video

## JavaDoc
* Ensure that all public APIs have JavaDoc
* Ensure that all parameters are documented with the @param doclet
* Can this be somewhat automated via checkstyle  ?

## FAQs
* We get many recurring questions on the forum / stackoverflow / IRC / etc. Try to distill some of the most significant ones you have answered successfully.
* Even questions that are related to product (sme-jdg, customer portal, etc) can be of use (obviously purged from any product reference)
* Things we CANNOT do are also important, and we should point out any limitations

## Performance Guide (Sebastian)
* This should be linked in the appropriate places from the User Guide

## Extending Infinispan (Will)
* At the moment this document is a bit pathetic. I suggest we drop it and fold the information in either the “Contributing to Infinispan” document or the “User Guide”

