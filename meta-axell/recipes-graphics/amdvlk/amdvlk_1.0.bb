DESCRIPTION = "AMD Vulkan Library"
LICENSE = "BSD"
RDEPENDS_${PN} = "libdrm vulkan-loader-layers"

LIC_FILES_CHKSUM = "file://amd_icd64.json;md5=afe65faab561beb34ccbf23340c2c53e \
"

SRC_URI = "file://amdvlk64.so \
	   file://amd_icd64.json \
"

PR = "r0"
PV = "1.0"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/${sysconfdir}/vulkan/icd.d
    install -m 0644 ${S}/amd_icd64.json ${D}/${sysconfdir}/vulkan/icd.d/
    install -vd ${D}/${libdir}
    install -m 0755 ${S}/amdvlk64.so ${D}/${libdir}
}

INSANE_SKIP_${PN} += "already-stripped ldflags file-rdeps"

FILES_${PN} += "${libdir}"
FILES_SOLIBSDEV = ""
