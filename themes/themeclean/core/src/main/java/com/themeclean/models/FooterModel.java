package com.themeclean.models;

import com.peregrine.nodetypes.models.AbstractComponent;
import com.peregrine.nodetypes.models.IComponent;
import com.peregrine.nodetypes.models.Container;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/*
    //GEN[:DATA
    {
  "definitions": {
    "Footer": {
      "type": "object",
      "x-type": "component",
      "properties": {
        "logo": {
          "type": "string",
          "x-source": "inject",
          "x-form-label": "Logo",
          "x-form-type": "pathbrowser",
          "x-form-browserRoot": "/content/assets"
        },
        "logourl": {
          "type": "string",
          "x-source": "inject",
          "x-form-label": "Logo Url",
          "x-form-type": "url"
        },
        "logosize": {
          "type": "string",
          "x-source": "inject",
          "x-form-label": "Logo Size",
          "x-form-type": "range",
          "x-form-min": 1,
          "x-form-max": 10
        },
        "title1": {
          "type": "string",
          "x-source": "inject",
          "x-form-label": "Column 1 Title ",
          "x-form-type": "text"
        },
        "text1": {
          "type": "string",
          "x-source": "inject",
          "x-form-label": "Column 1 Text",
          "x-form-type": "texteditor"
        },
        "title2": {
          "type": "string",
          "x-source": "inject",
          "x-form-label": "Column 2 Title",
          "x-form-type": "text"
        },
        "text2": {
          "type": "string",
          "x-source": "inject",
          "x-form-label": "Column 2 Text",
          "x-form-type": "texteditor"
        },
        "copyright": {
          "type": "string",
          "x-source": "inject",
          "x-form-label": "Copyright Text",
          "x-form-type": "text"
        },
        "linksref": {
          "x-form-type": "reference",
          "type": "object",
          "x-type": "component",
          "properties": {
            "title": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Links Section Title",
              "x-form-type": "text"
            },
            "links": {
              "type": "object",
              "x-source": "inject",
              "x-form-type": "collection",
              "x-form-label": "Links",
              "properties": {
                "text": {
                  "type": "string",
                  "x-source": "inject",
                  "x-form-label": "Link Text",
                  "x-form-type": "text"
                },
                "link": {
                  "type": "string",
                  "x-source": "inject",
                  "x-form-label": "Link Url",
                  "x-form-type": "pathbrowser",
                  "x-form-browserRoot": "/content/sites"
                }
              }
            }
          }
        },
        "socialref": {
          "x-form-type": "reference",
          "type": "object",
          "x-type": "component",
          "properties": {
            "iconcolor": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Icon Color",
              "x-default": "#000000",
              "x-form-type": "color"
            },
            "iconsize": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Icon Size",
              "x-form-type": "range",
              "x-default": "30",
              "x-form-min": 0,
              "x-form-max": 150
            },
            "icons": {
              "type": "object",
              "x-form-type": "collection",
              "x-form-label": "Icons",
              "x-source": "inject",
              "properties": {
                "icon": {
                  "type": "string",
                  "x-source": "inject",
                  "x-form-label": "Icon Chooser",
                  "x-form-type": "iconbrowser",
                  "x-form-hint": "Select an icon.",
                  "x-form-required": true,
                  "x-form-validator": "required",
                  "x-form-families": [
                    "material",
                    "font awesome"
                  ]
                },
                "url": {
                  "type": "string",
                  "x-source": "inject",
                  "x-form-label": "Icon Url",
                  "x-form-type": "pathbrowser",
                  "x-form-browserRoot": "/content/sites"
                }
              }
            }
          }
        },
        "bgref": {
          "x-form-type": "reference",
          "type": "object",
          "x-type": "component",
          "properties": {
            "colorscheme": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Block Color Scheme",
              "x-form-type": "materialradio",
              "x-default": "light",
              "properties": {
                "light": {
                  "x-form-name": "Light",
                  "x-form-value": "light"
                },
                "dark": {
                  "x-form-name": "Dark",
                  "x-form-value": "dark"
                }
              }
            },
            "custombackground": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Custom Background",
              "x-form-type": "materialswitch",
              "x-default": "false"
            },
            "backgroundtype": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Background Type",
              "x-form-type": "materialradio",
              "x-form-visible": "model.custombackground == 'true'",
              "properties": {
                "color": {
                  "x-form-name": "Color",
                  "x-form-value": "color"
                },
                "gradient": {
                  "x-form-name": "Gradient",
                  "x-form-value": "gradient"
                },
                "image": {
                  "x-form-name": "Image",
                  "x-form-value": "image"
                },
                "video": {
                  "x-form-name": "Video",
                  "x-form-value": "video"
                }
              }
            },
            "bgvideo": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Background Video",
              "x-form-type": "pathbrowser",
              "x-form-visible": "model.backgroundtype == 'video' and model.custombackground == 'true'",
              "x-default": "https://www.youtube.com/embed/Ju86mknumYM",
              "x-form-browserRoot": "/content/assets"
            },
            "bgimage": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Background Image",
              "x-form-type": "pathbrowser",
              "x-form-visible": "model.backgroundtype == 'image' and model.custombackground == 'true'",
              "x-form-browserRoot": "/content/assets"
            },
            "overlay": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Overlay",
              "x-form-type": "materialswitch",
              "x-form-visible": "model.backgroundtype == 'image' and model.custombackground == 'true'"
            },
            "overlaycolor": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Overlay Color",
              "x-form-type": "color",
              "x-form-visible": "model.overlay == 'true' and model.backgroundtype == 'image' and model.custombackground == 'true'",
              "x-default": "#ffffff"
            },
            "overlayopacity": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Overlay opacity",
              "x-form-type": "range",
              "x-form-min": 0,
              "x-form-max": 100,
              "x-form-visible": "model.overlay == 'true' and model.backgroundtype == 'image' and model.custombackground == 'true'",
              "x-default": "50"
            },
            "bgcolor": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Background Color",
              "x-form-type": "color",
              "x-form-visible": "model.backgroundtype == 'color' or model.backgroundtype == 'gradient' and model.custombackground == 'true'",
              "x-default": "#ffffff"
            },
            "color2": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Color 2",
              "x-form-type": "color",
              "x-form-visible": "model.backgroundtype == 'gradient' and model.custombackground == 'true'",
              "x-default": "#c0c0c0"
            },
            "fullwidth": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Full Width",
              "x-form-type": "materialswitch"
            },
            "fullheight": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Full Height",
              "x-form-type": "materialswitch"
            },
            "toppadding": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Top Padding",
              "x-form-type": "range",
              "x-form-min": 0,
              "x-form-max": 120,
              "x-form-visible": "model.fullheight != 'true'"
            },
            "bottompadding": {
              "type": "string",
              "x-source": "inject",
              "x-form-label": "Bottom Padding",
              "x-form-type": "range",
              "x-form-min": 0,
              "x-form-max": 150,
              "x-form-visible": "model.fullheight != 'true'"
            }
          }
        }
      }
    }
  },
  "name": "Footer",
  "componentPath": "themeclean/components/footer",
  "package": "com.themeclean.models",
  "modelName": "Footer",
  "classNameParent": "AbstractComponent"
}
//GEN]
*/

//GEN[:DEF
@Model(
        adaptables = Resource.class,
        resourceType = "themeclean/components/footer",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        adapters = IComponent.class
)
@Exporter(
        name = "jackson",
        extensions = "json"
)

//GEN]
public class FooterModel extends AbstractComponent {

    public FooterModel(Resource r) { super(r); }

    //GEN[:INJECT
    	/* {"type":"string","x-source":"inject","x-form-label":"Logo","x-form-type":"pathbrowser","x-form-browserRoot":"/content/assets"} */
	@Inject
	private String logo;

	/* {"type":"string","x-source":"inject","x-form-label":"Logo Url","x-form-type":"url"} */
	@Inject
	private String logourl;

	/* {"type":"string","x-source":"inject","x-form-label":"Logo Size","x-form-type":"range","x-form-min":1,"x-form-max":10} */
	@Inject
	private String logosize;

	/* {"type":"string","x-source":"inject","x-form-label":"Column 1 Title ","x-form-type":"text"} */
	@Inject
	private String title1;

	/* {"type":"string","x-source":"inject","x-form-label":"Column 1 Text","x-form-type":"texteditor"} */
	@Inject
	private String text1;

	/* {"type":"string","x-source":"inject","x-form-label":"Column 2 Title","x-form-type":"text"} */
	@Inject
	private String title2;

	/* {"type":"string","x-source":"inject","x-form-label":"Column 2 Text","x-form-type":"texteditor"} */
	@Inject
	private String text2;

	/* {"type":"string","x-source":"inject","x-form-label":"Copyright Text","x-form-type":"text"} */
	@Inject
	private String copyright;

	/* {"type":"string","x-source":"inject","x-form-label":"Links Section Title","x-form-type":"text"} */
	@Inject
	private String title;

	/* {"type":"object","x-source":"inject","x-form-type":"collection","x-form-label":"Links","properties":{"text":{"type":"string","x-source":"inject","x-form-label":"Link Text","x-form-type":"text"},"link":{"type":"string","x-source":"inject","x-form-label":"Link Url","x-form-type":"pathbrowser","x-form-browserRoot":"/content/sites"}}} */
	@Inject
	private List<IComponent> links;

	/* {"type":"string","x-source":"inject","x-form-label":"Icon Color","x-default":"#000000","x-form-type":"color"} */
	@Inject
	@Default(values ="#000000")
	private String iconcolor;

	/* {"type":"string","x-source":"inject","x-form-label":"Icon Size","x-form-type":"range","x-default":"30","x-form-min":0,"x-form-max":150} */
	@Inject
	@Default(values ="30")
	private String iconsize;

	/* {"type":"object","x-form-type":"collection","x-form-label":"Icons","x-source":"inject","properties":{"icon":{"type":"string","x-source":"inject","x-form-label":"Icon Chooser","x-form-type":"iconbrowser","x-form-hint":"Select an icon.","x-form-required":true,"x-form-validator":"required","x-form-families":["material","font awesome"]},"url":{"type":"string","x-source":"inject","x-form-label":"Icon Url","x-form-type":"pathbrowser","x-form-browserRoot":"/content/sites"}}} */
	@Inject
	private List<IComponent> icons;

	/* {"type":"string","x-source":"inject","x-form-label":"Block Color Scheme","x-form-type":"materialradio","x-default":"light","properties":{"light":{"x-form-name":"Light","x-form-value":"light"},"dark":{"x-form-name":"Dark","x-form-value":"dark"}}} */
	@Inject
	@Default(values ="light")
	private String colorscheme;

	/* {"type":"string","x-source":"inject","x-form-label":"Custom Background","x-form-type":"materialswitch","x-default":"false"} */
	@Inject
	@Default(values ="false")
	private String custombackground;

	/* {"type":"string","x-source":"inject","x-form-label":"Background Type","x-form-type":"materialradio","x-form-visible":"model.custombackground == 'true'","properties":{"color":{"x-form-name":"Color","x-form-value":"color"},"gradient":{"x-form-name":"Gradient","x-form-value":"gradient"},"image":{"x-form-name":"Image","x-form-value":"image"},"video":{"x-form-name":"Video","x-form-value":"video"}}} */
	@Inject
	private String backgroundtype;

	/* {"type":"string","x-source":"inject","x-form-label":"Background Video","x-form-type":"pathbrowser","x-form-visible":"model.backgroundtype == 'video' and model.custombackground == 'true'","x-default":"https://www.youtube.com/embed/Ju86mknumYM","x-form-browserRoot":"/content/assets"} */
	@Inject
	@Default(values ="https://www.youtube.com/embed/Ju86mknumYM")
	private String bgvideo;

	/* {"type":"string","x-source":"inject","x-form-label":"Background Image","x-form-type":"pathbrowser","x-form-visible":"model.backgroundtype == 'image' and model.custombackground == 'true'","x-form-browserRoot":"/content/assets"} */
	@Inject
	private String bgimage;

	/* {"type":"string","x-source":"inject","x-form-label":"Overlay","x-form-type":"materialswitch","x-form-visible":"model.backgroundtype == 'image' and model.custombackground == 'true'"} */
	@Inject
	private String overlay;

	/* {"type":"string","x-source":"inject","x-form-label":"Overlay Color","x-form-type":"color","x-form-visible":"model.overlay == 'true' and model.backgroundtype == 'image' and model.custombackground == 'true'","x-default":"#ffffff"} */
	@Inject
	@Default(values ="#ffffff")
	private String overlaycolor;

	/* {"type":"string","x-source":"inject","x-form-label":"Overlay opacity","x-form-type":"range","x-form-min":0,"x-form-max":100,"x-form-visible":"model.overlay == 'true' and model.backgroundtype == 'image' and model.custombackground == 'true'","x-default":"50"} */
	@Inject
	@Default(values ="50")
	private String overlayopacity;

	/* {"type":"string","x-source":"inject","x-form-label":"Background Color","x-form-type":"color","x-form-visible":"model.backgroundtype == 'color' or model.backgroundtype == 'gradient' and model.custombackground == 'true'","x-default":"#ffffff"} */
	@Inject
	@Default(values ="#ffffff")
	private String bgcolor;

	/* {"type":"string","x-source":"inject","x-form-label":"Color 2","x-form-type":"color","x-form-visible":"model.backgroundtype == 'gradient' and model.custombackground == 'true'","x-default":"#c0c0c0"} */
	@Inject
	@Default(values ="#c0c0c0")
	private String color2;

	/* {"type":"string","x-source":"inject","x-form-label":"Full Width","x-form-type":"materialswitch"} */
	@Inject
	private String fullwidth;

	/* {"type":"string","x-source":"inject","x-form-label":"Full Height","x-form-type":"materialswitch"} */
	@Inject
	private String fullheight;

	/* {"type":"string","x-source":"inject","x-form-label":"Top Padding","x-form-type":"range","x-form-min":0,"x-form-max":120,"x-form-visible":"model.fullheight != 'true'"} */
	@Inject
	private String toppadding;

	/* {"type":"string","x-source":"inject","x-form-label":"Bottom Padding","x-form-type":"range","x-form-min":0,"x-form-max":150,"x-form-visible":"model.fullheight != 'true'"} */
	@Inject
	private String bottompadding;


//GEN]

    //GEN[:GETTERS
    	/* {"type":"string","x-source":"inject","x-form-label":"Logo","x-form-type":"pathbrowser","x-form-browserRoot":"/content/assets"} */
	public String getLogo() {
		return logo;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Logo Url","x-form-type":"url"} */
	public String getLogourl() {
		return logourl;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Logo Size","x-form-type":"range","x-form-min":1,"x-form-max":10} */
	public String getLogosize() {
		return logosize;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Column 1 Title ","x-form-type":"text"} */
	public String getTitle1() {
		return title1;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Column 1 Text","x-form-type":"texteditor"} */
	public String getText1() {
		return text1;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Column 2 Title","x-form-type":"text"} */
	public String getTitle2() {
		return title2;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Column 2 Text","x-form-type":"texteditor"} */
	public String getText2() {
		return text2;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Copyright Text","x-form-type":"text"} */
	public String getCopyright() {
		return copyright;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Links Section Title","x-form-type":"text"} */
	public String getTitle() {
		return title;
	}

	/* {"type":"object","x-source":"inject","x-form-type":"collection","x-form-label":"Links","properties":{"text":{"type":"string","x-source":"inject","x-form-label":"Link Text","x-form-type":"text"},"link":{"type":"string","x-source":"inject","x-form-label":"Link Url","x-form-type":"pathbrowser","x-form-browserRoot":"/content/sites"}}} */
	public List<IComponent> getLinks() {
		return links;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Icon Color","x-default":"#000000","x-form-type":"color"} */
	public String getIconcolor() {
		return iconcolor;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Icon Size","x-form-type":"range","x-default":"30","x-form-min":0,"x-form-max":150} */
	public String getIconsize() {
		return iconsize;
	}

	/* {"type":"object","x-form-type":"collection","x-form-label":"Icons","x-source":"inject","properties":{"icon":{"type":"string","x-source":"inject","x-form-label":"Icon Chooser","x-form-type":"iconbrowser","x-form-hint":"Select an icon.","x-form-required":true,"x-form-validator":"required","x-form-families":["material","font awesome"]},"url":{"type":"string","x-source":"inject","x-form-label":"Icon Url","x-form-type":"pathbrowser","x-form-browserRoot":"/content/sites"}}} */
	public List<IComponent> getIcons() {
		return icons;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Block Color Scheme","x-form-type":"materialradio","x-default":"light","properties":{"light":{"x-form-name":"Light","x-form-value":"light"},"dark":{"x-form-name":"Dark","x-form-value":"dark"}}} */
	public String getColorscheme() {
		return colorscheme;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Custom Background","x-form-type":"materialswitch","x-default":"false"} */
	public String getCustombackground() {
		return custombackground;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Background Type","x-form-type":"materialradio","x-form-visible":"model.custombackground == 'true'","properties":{"color":{"x-form-name":"Color","x-form-value":"color"},"gradient":{"x-form-name":"Gradient","x-form-value":"gradient"},"image":{"x-form-name":"Image","x-form-value":"image"},"video":{"x-form-name":"Video","x-form-value":"video"}}} */
	public String getBackgroundtype() {
		return backgroundtype;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Background Video","x-form-type":"pathbrowser","x-form-visible":"model.backgroundtype == 'video' and model.custombackground == 'true'","x-default":"https://www.youtube.com/embed/Ju86mknumYM","x-form-browserRoot":"/content/assets"} */
	public String getBgvideo() {
		return bgvideo;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Background Image","x-form-type":"pathbrowser","x-form-visible":"model.backgroundtype == 'image' and model.custombackground == 'true'","x-form-browserRoot":"/content/assets"} */
	public String getBgimage() {
		return bgimage;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Overlay","x-form-type":"materialswitch","x-form-visible":"model.backgroundtype == 'image' and model.custombackground == 'true'"} */
	public String getOverlay() {
		return overlay;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Overlay Color","x-form-type":"color","x-form-visible":"model.overlay == 'true' and model.backgroundtype == 'image' and model.custombackground == 'true'","x-default":"#ffffff"} */
	public String getOverlaycolor() {
		return overlaycolor;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Overlay opacity","x-form-type":"range","x-form-min":0,"x-form-max":100,"x-form-visible":"model.overlay == 'true' and model.backgroundtype == 'image' and model.custombackground == 'true'","x-default":"50"} */
	public String getOverlayopacity() {
		return overlayopacity;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Background Color","x-form-type":"color","x-form-visible":"model.backgroundtype == 'color' or model.backgroundtype == 'gradient' and model.custombackground == 'true'","x-default":"#ffffff"} */
	public String getBgcolor() {
		return bgcolor;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Color 2","x-form-type":"color","x-form-visible":"model.backgroundtype == 'gradient' and model.custombackground == 'true'","x-default":"#c0c0c0"} */
	public String getColor2() {
		return color2;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Full Width","x-form-type":"materialswitch"} */
	public String getFullwidth() {
		return fullwidth;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Full Height","x-form-type":"materialswitch"} */
	public String getFullheight() {
		return fullheight;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Top Padding","x-form-type":"range","x-form-min":0,"x-form-max":120,"x-form-visible":"model.fullheight != 'true'"} */
	public String getToppadding() {
		return toppadding;
	}

	/* {"type":"string","x-source":"inject","x-form-label":"Bottom Padding","x-form-type":"range","x-form-min":0,"x-form-max":150,"x-form-visible":"model.fullheight != 'true'"} */
	public String getBottompadding() {
		return bottompadding;
	}


//GEN]

    //GEN[:CUSTOMGETTERS
    //GEN]

}
