# Overview of the folder structure:

Readme's / help texts / code comments are contained in the respective structures. This is a small navigation aid through the created folders. Each folder basically represents its own server instance.

### Masterportal - Frotend : 
- Code of the forked opensource master portal application (https://bitbucket.org/geowerkstatt-hamburg/masterportal/downloads/)with various 
- Various customisations for the usability of the application for the purposes of this research project. We will only go into the relevant ones.
- major customisations with the configuration for our application (buttons, services for our various layers for data display, see more details under the heading "Geoserver"): "Frontend\portal\test_portal"
- *Relevant for the paper*: "addons\dvan\decision_support" All interface elements for controlling communication with the backend can be found here

### Geoserver folder:
In our application, the geodata that is displayed in the Frotend via WMS is stored here. We cannot make the data available for legal reasons and in consideration of our contractual partner and the data protection relevance of location data.

### Backend:
Backend and the necessary methods:

- "mcda_backend": Contains part of the multi-tier methods
- "openaccessibilityservice": provides a set of services to answer complex spatial accessibility problems that are used to calculate city locations and population. This also includes methods from other papers, such as those described in the article linked in this paper _"Krügel, F.; Mäs, S. A Web-Application for Measuring Spatial Accessibility in Health Planning. AGILE GIScience Ser. 2023, 4, 1-11, doi:10.5194/agile-giss-4-6-2023."
- "openrouteservice": The instance enables the routing calculation and the catchment area calculation that we need for the methods mentioned above. (HeiGIT. openrouteservice. Available online: https://openrouteservice.org/ (accessed on 9 November 2023)_)